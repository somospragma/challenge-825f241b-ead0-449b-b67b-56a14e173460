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