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