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