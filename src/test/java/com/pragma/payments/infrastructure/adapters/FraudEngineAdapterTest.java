package com.pragma.payments.infrastructure.adapters;

import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FraudEngineAdapterTest {

    @Mock
    private FraudEngineService fraudEngineService;

    @InjectMocks
    private FraudEngineAdapter fraudEngineAdapter;

    @Test
    void checkFraud_shouldReturnSuccess() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");
        PaymentResponse paymentResponse = PaymentResponse.accepted("123", "accepted");

        when(fraudEngineService.checkFraud(paymentRequest)).thenReturn(Mono.just(true));

        StepVerifier.create(fraudEngineAdapter.checkFraud(paymentRequest))
               .expectNext(true)
               .verifyComplete();
    }

    @Test
    void checkFraud_shouldReturnFailure() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");

        when(fraudEngineService.checkFraud(paymentRequest)).thenReturn(Mono.just(false));

        StepVerifier.create(fraudEngineAdapter.checkFraud(paymentRequest))
               .expectNext(false)
               .verifyComplete();
    }

    @Test
    void checkFraud_shouldHandleException() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");

        when(fraudEngineService.checkFraud(paymentRequest)).thenReturn(Mono.error(new RuntimeException("Fraud check failed")));

        StepVerifier.create(fraudEngineAdapter.checkFraud(paymentRequest))
               .expectError(RuntimeException.class)
               .verify();
    }
}