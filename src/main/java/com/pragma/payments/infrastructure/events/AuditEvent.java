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