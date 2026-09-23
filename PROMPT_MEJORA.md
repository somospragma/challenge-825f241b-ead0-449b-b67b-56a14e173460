# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/pragma/payments/infrastructure/config/SecurityConfig.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/payments/infrastructure/security/JwtTokenUtil.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/payments/infrastructure/security/JwtAuthenticationFilter.java` — El topic pide autenticacion/seguridad: este archivo es el ejercicio.
- `src/main/java/com/pragma/payments/infrastructure/config/ResilienceConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/payments/infrastructure/adapters/RiskBureauAdapter.java` — `com.pragma.payments.application.ports.RiskBureauPort`: El import com.pragma.payments.application.ports.RiskBureauPort usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/pragma/payments/infrastructure/adapters/RiskBureauAdapter.java` — `com.pragma.payments.domain.model.RiskAssessment`: El import com.pragma.payments.domain.model.RiskAssessment usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/pragma/payments/infrastructure/adapters/RiskBureauAdapter.java` — `com.pragma.payments.domain.model.RiskRequest`: El import com.pragma.payments.domain.model.RiskRequest usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/pragma/payments/infrastructure/adapters/CoreBankingAdapter.java` — `com.pragma.payments.application.ports.CoreBankingPort`: El import com.pragma.payments.application.ports.CoreBankingPort usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/pragma/payments/Application.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/application/ports/PaymentServicePort.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/application/usecases/PaymentUseCase.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/infrastructure/adapters/PaymentController.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/infrastructure/adapters/FraudEngineAdapter.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/infrastructure/adapters/RiskBureauAdapter.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/infrastructure/adapters/CoreBankingAdapter.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/infrastructure/config/ResilienceConfig.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/infrastructure/security/JwtTokenUtil.java` — `io.jsonwebtoken`: El import io.jsonwebtoken.Claims pertenece a io.jsonwebtoken, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/infrastructure/security/JwtAuthenticationFilter.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/infrastructure/events/AuditEventPublisher.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/infrastructure/config/OpenApiConfig.java` — `io.swagger.v3`: El import io.swagger.v3.oas.models.OpenAPI pertenece a io.swagger.v3, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/pragma/payments/application/usecases/PaymentUseCaseTest.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/pragma/payments/infrastructure/adapters/PaymentControllerTest.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/pragma/payments/infrastructure/adapters/FraudEngineAdapterTest.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/payments/infrastructure/adapters/CoreBankingAdapter.java` — `PaymentRequest.idempotencyKey`: Se invoca `idempotencyKey` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Spring, Tecnología Java, Senior L2

### Brecha de conocimiento
Comprueba riesgos, vulnerabilidades y amenazas; OWASP Top 10, CWE, Integrar un modelo de seguridad en arquitectura distribuida cloud

### Misión / candidato
Endurecer un servicio de pagos distribuido

### Datos adicionales
Candidato con 4 años de experiencia, equipo distribuido

### Reto
- Tema: Analiza riesgos y vulnerabilidades de seguridad
- Seniority: senior-l2
- Tipo: practical
- Título: Endurecimiento de un servicio de pagos distribuido
- Tiempo estimado: 1 semana

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Evaluación de riesgos y vulnerabilidades — objetivo: Identificar y documentar los riesgos y vulnerabilidades del servicio de pagos — entregable (NO resolver): Documento de evaluación de riesgos y vulnerabilidades
- Fase 2: Implementación de mitigaciones — objetivo: Implementar mitigaciones para los riesgos y vulnerabilidades identificados — entregable (NO resolver): Implementación de mitigaciones en el servicio de pagos
- Fase 3: Validación y auditoría — objetivo: Validar y auditar las mitigaciones implementadas — entregable (NO resolver): Reporte de validación y auditoría de las mitigaciones implementadas

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>payments</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>payments</name>
    <description>Servicio de pagos distribuido con manejo de riesgos y seguridad</description>

    <properties>
        <java.version>21</java.version>
        <resilience4j.version>2.2.0</resilience4j.version>
        <springdoc-openapi.version>2.5.0</springdoc-openapi.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis-reactive</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- Resilience4j -->
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot3</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-reactor</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- AWS SDK -->
        <dependency>
            <groupId>software.amazon.awssdk</groupId>
            <artifactId>sns</artifactId>
        </dependency>

        <!-- OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webflux-ui</artifactId>
            <version>${springdoc-openapi.version}</version>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/payments/Application.java ===
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

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: payments-service
  profiles:
    active: dev
  webflux:
    base-path: /api/payments
  datasource:
    url: jdbc:postgresql://localhost:5432/payments_db
    username: payments_user
    password: payments_pass
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 20
      connection-timeout: 30000
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
  redis:
    host: localhost
    port: 6379
    timeout: 5000ms
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://auth.pragma.com/realms/payments-realm
          jwk-set-uri: https://auth.pragma.com/realms/payments-realm/protocol/openid-connect/certs

server:
  port: 8080
  shutdown: graceful

management:
  endpoints:
    web:
      exposure:
        include: health,metrics,info,prometheus
  endpoint:
    health:
      probes:
        enabled: true
      group:
        readiness:
          include: readinessState,redis
        liveness:
          include: livenessState
  metrics:
    tags:
      application: ${spring.application.name}

resilience4j:
  circuitbreaker:
    instances:
      riskBureau:
        registerHealthIndicator: true
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
        slowCallDurationThreshold: 2s
        slowCallRateThreshold: 100
      coreBanking:
        registerHealthIndicator: true
        slidingWindowSize: 10
        permittedNumberOfCallsInHalfOpenState: 3
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
      fraudEngine:
        registerHealthIndicator: true
        slidingWindowSize: 10
        permittedNumberOfCallsInHalfOpenState: 3
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
  retry:
    instances:
      riskBureau:
        maxAttempts: 3
        waitDuration: 500ms
        retryExceptions:
          - com.pragma.payments.domain.exception.TimeoutException
      coreBanking:
        maxAttempts: 3
        waitDuration: 500ms
        retryExceptions:
          - org.springframework.web.client.HttpServerErrorException
      fraudEngine:
        maxAttempts: 3
        waitDuration: 500ms
        retryExceptions:
          - com.pragma.payments.domain.exception.TimeoutException
  ratelimiter:
    instances:
      paymentProcessing:
        limitForPeriod: 1500
        limitRefreshPeriod: 1s
        timeoutDuration: 0

services:
  external:
    riskBureau:
      url: https://risk-bureau.pragma.com/api/v1/assessment
      timeout: 2000
    coreBanking:
      url: https://core-banking.pragma.com/api/v1/transactions
      timeout: 3000
    fraudEngine:
      url: https://fraud-engine.pragma.com/api/v1/score
      timeout: 1500
    audit:
      snsTopicArn: arn:aws:sns:us-east-1:123456789012:payments-audit-events

// === ARCHIVO: src/main/java/com/pragma/payments/application/ports/PaymentServicePort.java ===
package com.pragma.payments.application.ports;

import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import reactor.core.publisher.Mono;

/**
 * Puerto definido por el dominio para procesar pagos de manera reactiva.
 * La implementación de este puerto será proporcionada por la capa de infraestructura.
 */
public interface PaymentServicePort {
    /**
     * Procesa una solicitud de pago, aplicando las reglas de negocio y validaciones.
     * 
     * @param paymentRequest la solicitud de pago que incluye los datos del pago y la clave de idempotencia.
     * @return un Mono que emite la respuesta del pago con el estado y detalles de la transacción.
     * @throws com.pragma.payments.domain.exception.PaymentProcessingException si ocurre un error durante el procesamiento.
     * @throws com.pragma.payments.domain.exception.TimeoutException si el procesamiento excede el tiempo límite.
     * @throws com.pragma.payments.domain.exception.IdempotencyException si se detecta un intento de procesamiento duplicado.
     */
    Mono<PaymentResponse> processPayment(PaymentRequest paymentRequest);
}

// === ARCHIVO: src/main/java/com/pragma/payments/domain/model/PaymentRequest.java ===
package com.pragma.payments.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Modelo de dominio que representa una solicitud de pago.
 * Incluye validaciones de negocio y campos para garantizar idempotencia.
 */
public record PaymentRequest(
    UUID paymentId,
    String operationNumber,
    String channel,
    String customerId,
    String accountFrom,
    String accountTo,
    BigDecimal amount,
    String currency,
    LocalDateTime requestTimestamp,
    String idempotencyKey
) {
    /**
     * Constructor compacto para crear una solicitud de pago con validaciones básicas.
     * 
     * @param paymentId identificador único del pago.
     * @param operationNumber número de operación generado por el canal.
     * @param channel canal desde el cual se origina la solicitud (ej: "MOBILE", "WEB", "POS").
     * @param customerId identificador del cliente.
     * @param accountFrom cuenta de origen del pago.
     * @param accountTo cuenta de destino del pago.
     * @param amount monto del pago.
     * @param currency moneda del pago.
     * @param requestTimestamp marca de tiempo de la solicitud.
     * @param idempotencyKey clave de idempotencia compuesta por operationNumber y channel.
     * @throws IllegalArgumentException si alguno de los campos requeridos es nulo o vacío.
     */
    public PaymentRequest {
        if (paymentId == null) {
            throw new IllegalArgumentException("El paymentId no puede ser nulo");
        }
        if (operationNumber == null || operationNumber.isBlank()) {
            throw new IllegalArgumentException("El operationNumber no puede ser nulo o vacío");
        }
        if (channel == null || channel.isBlank()) {
            throw new IllegalArgumentException("El channel no puede ser nulo o vacío");
        }
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("El customerId no puede ser nulo o vacío");
        }
        if (accountFrom == null || accountFrom.isBlank()) {
            throw new IllegalArgumentException("La accountFrom no puede ser nula o vacía");
        }
        if (accountTo == null || accountTo.isBlank()) {
            throw new IllegalArgumentException("La accountTo no puede ser nula o vacía");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El amount debe ser un valor positivo");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("La currency no puede ser nula o vacía");
        }
        if (requestTimestamp == null) {
            throw new IllegalArgumentException("El requestTimestamp no puede ser nulo");
        }
        if (idempotencyKey == null || idempotencyKey.isBlank()) {
            throw new IllegalArgumentException("La idempotencyKey no puede ser nula o vacía");
        }
    }

    /**
     * Genera una clave de idempotencia a partir del número de operación y el canal.
     * 
     * @param operationNumber número de operación.
     * @param channel canal de origen.
     * @return clave de idempotencia en formato "operationNumber:channel".
     */
    public static String generateIdempotencyKey(String operationNumber, String channel) {
        return operationNumber + ":" + channel;
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/domain/model/PaymentResponse.java ===
package com.pragma.payments.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Modelo de dominio que representa la respuesta de un pago procesado.
 * Contiene el estado de la transacción y detalles relevantes.
 */
public record PaymentResponse(
    UUID paymentId,
    String operationNumber,
    String status,
    String statusDetail,
    BigDecimal amount,
    String currency,
    LocalDateTime responseTimestamp,
    String fraudCheckStatus,
    String riskBureauStatus,
    String coreBankingStatus
) {
    /**
     * Constructor compacto para crear una respuesta de pago.
     * 
     * @param paymentId identificador único del pago.
     * @param operationNumber número de operación.
     * @param status estado general del pago (ej: "ACCEPTED", "REJECTED", "PENDING").
     * @param statusDetail detalle adicional del estado.
     * @param amount monto del pago.
     * @param currency moneda del pago.
     * @param responseTimestamp marca de tiempo de la respuesta.
     * @param fraudCheckStatus estado de la verificación antifraude.
     * @param riskBureauStatus estado del buró de riesgos.
     * @param coreBankingStatus estado del core bancario.
     * @throws IllegalArgumentException si alguno de los campos requeridos es nulo o vacío.
     */
    public PaymentResponse {
        if (paymentId == null) {
            throw new IllegalArgumentException("El paymentId no puede ser nulo");
        }
        if (operationNumber == null || operationNumber.isBlank()) {
            throw new IllegalArgumentException("El operationNumber no puede ser nulo o vacío");
        }
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("El status no puede ser nulo o vacío");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El amount debe ser un valor positivo");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("La currency no puede ser nula o vacía");
        }
        if (responseTimestamp == null) {
            throw new IllegalArgumentException("El responseTimestamp no puede ser nulo");
        }
    }

    /**
     * Crea una respuesta de pago con estado ACCEPTED.
     * 
     * @param paymentId identificador único del pago.
     * @param operationNumber número de operación.
     * @param amount monto del pago.
     * @param currency moneda del pago.
     * @param fraudCheckStatus estado de la verificación antifraude.
     * @param riskBureauStatus estado del buró de riesgos.
     * @param coreBankingStatus estado del core bancario.
     * @return una instancia de PaymentResponse con estado ACCEPTED y detalles proporcionados.
     */
    public static PaymentResponse accepted(
        UUID paymentId,
        String operationNumber,
        BigDecimal amount,
        String currency,
        String fraudCheckStatus,
        String riskBureauStatus,
        String coreBankingStatus
    ) {
        return new PaymentResponse(
            paymentId,
            operationNumber,
            "ACCEPTED",
            "Pago procesado exitosamente",
            amount,
            currency,
            LocalDateTime.now(),
            fraudCheckStatus,
            riskBureauStatus,
            coreBankingStatus
        );
    }

    /**
     * Crea una respuesta de pago con estado REJECTED.
     * 
     * @param paymentId identificador único del pago.
     * @param operationNumber número de operación.
     * @param statusDetail detalle del motivo de rechazo.
     * @param amount monto del pago.
     * @param currency moneda del pago.
     * @return una instancia de PaymentResponse con estado REJECTED y detalles proporcionados.
     */
    public static PaymentResponse rejected(
        UUID paymentId,
        String operationNumber,
        String statusDetail,
        BigDecimal amount,
        String currency
    ) {
        return new PaymentResponse(
            paymentId,
            operationNumber,
            "REJECTED",
            statusDetail,
            amount,
            currency,
            LocalDateTime.now(),
            null,
            null,
            null
        );
    }

    /**
     * Crea una respuesta de pago con estado PENDING.
     * 
     * @param paymentId identificador único del pago.
     * @param operationNumber número de operación.
     * @param statusDetail detalle del motivo de pendiente.
     * @param amount monto del pago.
     * @param currency moneda del pago.
     * @return una instancia de PaymentResponse con estado PENDING y detalles proporcionados.
     */
    public static PaymentResponse pending(
        UUID paymentId,
        String operationNumber,
        String statusDetail,
        BigDecimal amount,
        String currency
    ) {
        return new PaymentResponse(
            paymentId,
            operationNumber,
            "PENDING",
            statusDetail,
            amount,
            currency,
            LocalDateTime.now(),
            null,
            null,
            null
        );
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/domain/exception/PaymentProcessingException.java ===
package com.pragma.payments.domain.exception;

import com.pragma.payments.domain.model.PaymentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PaymentProcessingException extends ResponseStatusException {
    private final PaymentRequest paymentRequest;

    public PaymentProcessingException(PaymentRequest paymentRequest, String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Error processing payment: " + reason);
        this.paymentRequest = paymentRequest;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/domain/exception/TimeoutException.java ===
package com.pragma.payments.domain.exception;

import com.pragma.payments.domain.model.PaymentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TimeoutException extends ResponseStatusException {
    private final PaymentRequest paymentRequest;

    public TimeoutException(PaymentRequest paymentRequest, String service) {
        super(HttpStatus.GATEWAY_TIMEOUT, "Timeout when calling " + service);
        this.paymentRequest = paymentRequest;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/domain/exception/IdempotencyException.java ===
package com.pragma.payments.domain.exception;

import com.pragma.payments.domain.model.PaymentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IdempotencyException extends ResponseStatusException {
    private final PaymentRequest paymentRequest;

    public IdempotencyException(PaymentRequest paymentRequest) {
        super(HttpStatus.CONFLICT, "Idempotency violation for payment request");
        this.paymentRequest = paymentRequest;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/application/usecases/PaymentUseCase.java ===
package com.pragma.payments.application.usecases;

import com.pragma.payments.application.ports.PaymentServicePort;
import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import com.pragma.payments.domain.exception.PaymentProcessingException;
import com.pragma.payments.domain.exception.TimeoutException;
import com.pragma.payments.domain.exception.IdempotencyException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PaymentUseCase {

    private final PaymentServicePort paymentServicePort;

    @Autowired
    public PaymentUseCase(PaymentServicePort paymentServicePort) {
        this.paymentServicePort = paymentServicePort;
    }

    @CircuitBreaker(name = "paymentCircuitBreaker", fallbackMethod = "fallbackPayment")
    @Retry(name = "paymentRetry")
    @Bulkhead(name = "paymentBulkhead")
    public Mono<PaymentResponse> processPayment(PaymentRequest paymentRequest) {
        String idempotencyKey = paymentRequest.generateIdempotencyKey();
        return paymentServicePort.processPayment(paymentRequest)
           .flatMap(response -> {
                if (response.status().equals("PENDING")) {
                    throw new TimeoutException("Payment processing timed out");
                }
                return Mono.just(response);
            })
           .onErrorResume(ex -> {
                if (ex instanceof IdempotencyException) {
                    return Mono.error(new PaymentProcessingException("Idempotency key already exists"));
                }
                return Mono.error(ex);
            });
    }

    public Mono<PaymentResponse> fallbackPayment(PaymentRequest paymentRequest, Throwable t) {
        return Mono.just(PaymentResponse.rejected("Payment failed due to circuit breaker" + t.getMessage()));
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/adapters/PaymentController.java ===
package com.pragma.payments.infrastructure.adapters;

import com.pragma.payments.application.usecases.PaymentUseCase;
import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentUseCase paymentUseCase;

    @Autowired
    public PaymentController(PaymentUseCase paymentUseCase) {
        this.paymentUseCase = paymentUseCase;
    }

    @PostMapping
    public Mono<ResponseEntity<PaymentResponse>> processPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentUseCase.processPayment(paymentRequest)
           .map(ResponseEntity::ok)
           .onErrorResume(ex -> Mono.just(ResponseEntity.status(500).body(new PaymentResponse("ERROR", ex.getMessage()))));
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/adapters/FraudEngineAdapter.java ===
package com.pragma.payments.infrastructure.adapters;

import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class FraudEngineAdapter {

    @Value("${fraud.engine.url}")
    private String fraudEngineUrl;

    @CircuitBreaker(name = "fraudCircuitBreaker", fallbackMethod = "fallbackFraudCheck")
    @Retry(name = "fraudRetry")
    public Mono<PaymentResponse> checkFraud(PaymentRequest paymentRequest) {
        // Simulate fraud engine check
        return Mono.just(PaymentResponse.accepted("Fraud check passed"));
    }

    public Mono<PaymentResponse> fallbackFraudCheck(PaymentRequest paymentRequest, Throwable t) {
        return Mono.just(PaymentResponse.rejected("Fraud check failed due to circuit breaker" + t.getMessage()));
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/adapters/RiskBureauAdapter.java ===
package com.pragma.payments.infrastructure.adapters;

import com.pragma.payments.application.ports.RiskBureauPort;
import com.pragma.payments.domain.model.RiskAssessment;
import com.pragma.payments.domain.model.RiskRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RiskBureauAdapter implements RiskBureauPort {

    @CircuitBreaker(name = "riskBureau", fallbackMethod = "fallbackRiskAssessment")
    @Retry(name = "riskBureau")
    @RateLimiter(name = "riskBureau")
    @Override
    public Mono<RiskAssessment> assessRisk(RiskRequest riskRequest) {
        // Simulate a call to the risk bureau
        return Mono.just(new RiskAssessment("LOW"));
    }

    public Mono<RiskAssessment> fallbackRiskAssessment(RiskRequest riskRequest, Throwable t) {
        return Mono.just(new RiskAssessment("FALLBACK"));
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/adapters/CoreBankingAdapter.java ===
package com.pragma.payments.infrastructure.adapters;

import com.pragma.payments.application.ports.CoreBankingPort;
import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CoreBankingAdapter implements CoreBankingPort {

    @CircuitBreaker(name = "coreBanking", fallbackMethod = "fallbackPaymentProcessing")
    @Retry(name = "coreBanking")
    @RateLimiter(name = "coreBanking")
    @Override
    public Mono<PaymentResponse> processPayment(PaymentRequest paymentRequest) {
        // Simulate a call to the core banking system
        return Mono.just(new PaymentResponse("ACCEPTED", paymentRequest.idempotencyKey()));
    }

    public Mono<PaymentResponse> fallbackPaymentProcessing(PaymentRequest paymentRequest, Throwable t) {
        return Mono.just(new PaymentResponse("FALLBACK", paymentRequest.idempotencyKey()));
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/config/ResilienceConfig.java ===
package com.pragma.payments.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import io.github.resilience4j.reactor.retry.operator.RetryOperator;
import io.github.resilience4j.reactor.ratelimiter.operator.RateLimiterOperator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class ResilienceConfig {

    @Bean
    public CircuitBreakerOperator riskBureauCircuitBreakerOperator() {
        return CircuitBreakerOperator.of("riskBureau");
    }

    @Bean
    public RetryOperator riskBureauRetryOperator() {
        return RetryOperator.of("riskBureau");
    }

    @Bean
    public RateLimiterOperator riskBureauRateLimiterOperator() {
        return RateLimiterOperator.of("riskBureau");
    }

    @Bean
    public CircuitBreakerOperator coreBankingCircuitBreakerOperator() {
        return CircuitBreakerOperator.of("coreBanking");
    }

    @Bean
    public RetryOperator coreBankingRetryOperator() {
        return RetryOperator.of("coreBanking");
    }

    @Bean
    public RateLimiterOperator coreBankingRateLimiterOperator() {
        return RateLimiterOperator.of("coreBanking");
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/config/SecurityConfig.java ===
package com.pragma.payments.infrastructure.config;

import com.pragma.payments.infrastructure.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
           .authorizeExchange(exchanges -> exchanges
               .anyExchange().authenticated())
           .addFilterAt(jwtAuthenticationFilter(), ServerHttpSecurity.EndpointRequest.toAnyEndpoint());

        return http.build();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/security/JwtTokenUtil.java ===
package com.pragma.payments.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final String SECRET_KEY = "secret";

    public String generateToken(String subject) {
        return Jwts.builder()
           .setSubject(subject)
           .setIssuedAt(new Date())
           .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
           .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
           .compact();
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
           .setSigningKey(SECRET_KEY)
           .parseClaimsJws(token)
           .getBody();
    }

    public Boolean validateToken(String token) {
        try {
            getClaimsFromToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/security/JwtAuthenticationFilter.java ===
package com.pragma.payments.infrastructure.security;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        // Placeholder for JWT authentication logic
        return chain.filter(exchange);
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/events/AuditEventPublisher.java ===
package com.pragma.payments.infrastructure.events;

import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.SnsException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuditEventPublisher {

    private final SnsClient snsClient;

    public AuditEventPublisher(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    public Mono<Void> publishAuditEvent(PaymentRequest paymentRequest, PaymentResponse paymentResponse) {
        AuditEvent auditEvent = new AuditEvent(paymentRequest, paymentResponse);
        String message = auditEvent.toString();
        PublishRequest publishRequest = PublishRequest.builder()
               .topicArn("arn:aws:sns:us-east-1:123456789012:payment-audit")
               .message(message)
               .build();

        return Mono.fromFuture(snsClient.publish(publishRequest))
               .then();
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/events/AuditEvent.java ===
package com.pragma.payments.infrastructure.events;

import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;

public class AuditEvent {

    private final PaymentRequest paymentRequest;
    private final PaymentResponse paymentResponse;

    public AuditEvent(PaymentRequest paymentRequest, PaymentResponse paymentResponse) {
        this.paymentRequest = paymentRequest;
        this.paymentResponse = paymentResponse;
    }

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public PaymentResponse getPaymentResponse() {
        return paymentResponse;
    }

    @Override
    public String toString() {
        return "AuditEvent{" +
                "paymentRequest=" + paymentRequest +
                ", paymentResponse=" + paymentResponse +
                '}';
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/config/OpenApiConfig.java ===
package com.pragma.payments.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
               .info(new Info().title("Payments API")
                       .description("API for payment processing")
                       .version("1.0"));
    }

    @Bean
    public GroupedOpenApi paymentsApi() {
        return GroupedOpenApi.builder()
               .group("payments")
               .pathsToMatch("/payments/**")
               .build();
    }
}

// === ARCHIVO: src/test/java/com/pragma/payments/application/usecases/PaymentUseCaseTest.java ===
package com.pragma.payments.application.usecases;

import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import com.pragma.payments.application.ports.PaymentServicePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentUseCaseTest {

    @Mock
    private PaymentServicePort paymentServicePort;

    @InjectMocks
    private PaymentUseCase paymentUseCase;

    @Test
    void processPayment_shouldReturnAcceptedResponse() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");
        PaymentResponse expectedResponse = PaymentResponse.accepted("123", "accepted");

        when(paymentServicePort.processPayment(paymentRequest)).thenReturn(Mono.just(expectedResponse));

        StepVerifier.create(paymentUseCase.processPayment(paymentRequest))
               .expectNext(expectedResponse)
               .verifyComplete();
    }

    @Test
    void processPayment_shouldReturnRejectedResponse() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");
        PaymentResponse expectedResponse = PaymentResponse.rejected("123", "rejected");

        when(paymentServicePort.processPayment(paymentRequest)).thenReturn(Mono.just(expectedResponse));

        StepVerifier.create(paymentUseCase.processPayment(paymentRequest))
               .expectNext(expectedResponse)
               .verifyComplete();
    }

    @Test
    void processPayment_shouldHandleIdempotency() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");
        PaymentResponse expectedResponse = PaymentResponse.accepted("123", "accepted");

        when(paymentServicePort.processPayment(paymentRequest)).thenReturn(Mono.just(expectedResponse));

        StepVerifier.create(paymentUseCase.processPayment(paymentRequest))
               .expectNext(expectedResponse)
               .verifyComplete();

        StepVerifier.create(paymentUseCase.processPayment(paymentRequest))
               .expectNext(expectedResponse)
               .verifyComplete();
    }

    @Test
    void processPayment_shouldHandleFailure() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");
        PaymentResponse expectedResponse = PaymentResponse.rejected("123", "rejected");

        when(paymentServicePort.processPayment(paymentRequest)).thenReturn(Mono.error(new RuntimeException("Payment processing failed")));

        StepVerifier.create(paymentUseCase.processPayment(paymentRequest))
               .expectError(RuntimeException.class)
               .verify();
    }
}

// === ARCHIVO: src/test/java/com/pragma/payments/infrastructure/adapters/PaymentControllerTest.java ===
package com.pragma.payments.infrastructure.adapters;

import com.pragma.payments.application.usecases.PaymentUseCase;
import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    @Mock
    private PaymentUseCase paymentUseCase;

    @InjectMocks
    private PaymentController paymentController;

    private WebTestClient webTestClient;

    @Test
    void processPayment_shouldReturnAcceptedResponse() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");
        PaymentResponse paymentResponse = PaymentResponse.accepted("123", "accepted");

        when(paymentUseCase.processPayment(paymentRequest)).thenReturn(Mono.just(paymentResponse));

        webTestClient = WebTestClient.bindToController(paymentController).build();

        webTestClient.post()
               .uri("/payments")
               .bodyValue(paymentRequest)
               .exchange()
               .expectStatus().isOk()
               .expectBody(PaymentResponse.class).isEqualTo(paymentResponse);
    }

    @Test
    void processPayment_shouldReturnRejectedResponse() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");
        PaymentResponse paymentResponse = PaymentResponse.rejected("123", "rejected");

        when(paymentUseCase.processPayment(paymentRequest)).thenReturn(Mono.just(paymentResponse));

        webTestClient = WebTestClient.bindToController(paymentController).build();

        webTestClient.post()
               .uri("/payments")
               .bodyValue(paymentRequest)
               .exchange()
               .expectStatus().isOk()
               .expectBody(PaymentResponse.class).isEqualTo(paymentResponse);
    }

    @Test
    void processPayment_shouldHandleAuthentication() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");

        webTestClient = WebTestClient.bindToController(paymentController).build();

        webTestClient.post()
               .uri("/payments")
               .bodyValue(paymentRequest)
               .exchange()
               .expectStatus().isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    void processPayment_shouldHandleErrors() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");

        when(paymentUseCase.processPayment(paymentRequest)).thenReturn(Mono.error(new RuntimeException("Payment processing failed")));

        webTestClient = WebTestClient.bindToController(paymentController).build();

        webTestClient.post()
               .uri("/payments")
               .bodyValue(paymentRequest)
               .exchange()
               .expectStatus().isInternalServerError();
    }
}

// === ARCHIVO: src/test/java/com/pragma/payments/infrastructure/adapters/FraudEngineAdapterTest.java ===
package com.pragma.payments.infrastructure.adapters;

import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FraudEngineAdapterTest {

    @Mock
    private FraudEngineService fraudEngineService;

    @InjectMocks
    private FraudEngineAdapter fraudEngineAdapter;

    @Test
    void checkFraud_shouldReturnSuccess() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");
        PaymentResponse paymentResponse = PaymentResponse.accepted("123", "accepted");

        when(fraudEngineService.checkFraud(paymentRequest)).thenReturn(Mono.just(true));

        StepVerifier.create(fraudEngineAdapter.checkFraud(paymentRequest))
               .expectNext(true)
               .verifyComplete();
    }

    @Test
    void checkFraud_shouldReturnFailure() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");

        when(fraudEngineService.checkFraud(paymentRequest)).thenReturn(Mono.just(false));

        StepVerifier.create(fraudEngineAdapter.checkFraud(paymentRequest))
               .expectNext(false)
               .verifyComplete();
    }

    @Test
    void checkFraud_shouldHandleException() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");

        when(fraudEngineService.checkFraud(paymentRequest)).thenReturn(Mono.error(new RuntimeException("Fraud check failed")));

        StepVerifier.create(fraudEngineAdapter.checkFraud(paymentRequest))
               .expectError(RuntimeException.class)
               .verify();
    }
}
```
