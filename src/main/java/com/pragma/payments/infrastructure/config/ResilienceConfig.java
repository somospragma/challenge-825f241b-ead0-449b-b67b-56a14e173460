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