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