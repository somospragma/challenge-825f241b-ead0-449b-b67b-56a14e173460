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