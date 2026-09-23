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