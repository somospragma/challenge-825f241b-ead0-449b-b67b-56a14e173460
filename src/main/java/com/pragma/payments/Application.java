package com.pragma.payments;




import com.pragma.payments.domain.exception.IdempotencyException;
import com.pragma.payments.domain.exception.PaymentProcessingException;
import com.pragma.payments.domain.exception.TimeoutException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableWebFlux
@EnableWebFluxSecurity
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/actuator/**").permitAll()
                        .pathMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(new JwtAuthenticationConverter()))
                )
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        return new JwtAuthenticationConverter();
    }

    // Configuración adicional para manejar excepciones globales
    @Bean
    public GlobalErrorWebExceptionHandler globalErrorWebExceptionHandler(
            ReactiveWebApplicationContext applicationContext,
            ServerCodecConfigurer serverCodecConfigurer) {
        return new GlobalErrorWebExceptionHandler(
                applicationContext.getBean(GlobalErrorAttributes.class),
                new WebProperties.Resources(),
                applicationContext,
                serverCodecConfigurer
        );
    }

    @Bean
    public GlobalErrorAttributes globalErrorAttributes() {
        return new GlobalErrorAttributes();
    }

    // Configuración de circuit breaker y retry para servicios externos
    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCircuitBreakerCustomizer() {
        return factory -> factory.configureDefault(id -> {
            CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                    .failureRateThreshold(50)
                    .waitDurationInOpenState(Duration.ofMillis(1000))
                    .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.TIME_BASED)
                    .slidingWindowSize(5)
                    .build();

            return CircuitBreaker.of(id, circuitBreakerConfig);
        });
    }

    @Bean
    public Customizer<ReactiveResilience4JRetryFactory> defaultRetryCustomizer() {
        return factory -> factory.configureDefault(id -> {
            RetryConfig retryConfig = RetryConfig.custom()
                    .maxAttempts(3)
                    .waitDuration(Duration.ofMillis(500))
                    .retryExceptions(TimeoutException.class, WebClientResponseException.class)
                    .build();

            return Retry.of(id, retryConfig);
        });
    }
}

// Clase interna para conversión de JWT
class JwtAuthenticationConverter implements Converter<Jwt, Mono<AbstractAuthenticationToken>> {
    @Override
    public Mono<AbstractAuthenticationToken> convert(Jwt jwt) {
        return Mono.just(new JwtAuthenticationToken(jwt, Collections.emptyList()));
    }
}

// Manejador global de errores
class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {
    public GlobalErrorWebExceptionHandler(ErrorAttributes errorAttributes, WebProperties.Resources resources,
                                         ApplicationContext applicationContext, ServerCodecConfigurer serverCodecConfigurer) {
        super(errorAttributes, resources, applicationContext);
        this.setMessageWriters(serverCodecConfigurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    private Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
        Map<String, Object> errorPropertiesMap = getErrorAttributes(request, ErrorAttributeOptions.defaults());
        int status = (int) errorPropertiesMap.get("status");

        return ServerResponse.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(errorPropertiesMap);
    }
}

// Atributos personalizados para errores
class GlobalErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Throwable error = super.getError(request);
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, options);

        if (error instanceof PaymentProcessingException) {
            errorAttributes.put("message", error.getMessage());
            errorAttributes.put("code", ((PaymentProcessingException) error).getCode());
        } else if (error instanceof TimeoutException) {
            errorAttributes.put("message", "Timeout al procesar la solicitud");
            errorAttributes.put("code", "TIMEOUT_ERROR");
        } else if (error instanceof IdempotencyException) {
            errorAttributes.put("message", "Operación duplicada");
            errorAttributes.put("code", "IDEMPOTENCY_ERROR");
        }

        return errorAttributes;
    }
}