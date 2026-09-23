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