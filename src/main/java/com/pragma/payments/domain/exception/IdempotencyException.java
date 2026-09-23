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