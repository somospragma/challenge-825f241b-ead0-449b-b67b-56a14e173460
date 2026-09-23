package com.pragma.payments.infrastructure.adapters;

import com.pragma.payments.application.usecases.PaymentUseCase;
import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentControllerTest {

    @Mock
    private PaymentUseCase paymentUseCase;

    @InjectMocks
    private PaymentController paymentController;

    private WebTestClient webTestClient;

    @Test
    void processPayment_shouldReturnAcceptedResponse() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");
        PaymentResponse paymentResponse = PaymentResponse.accepted("123", "accepted");

        when(paymentUseCase.processPayment(paymentRequest)).thenReturn(Mono.just(paymentResponse));

        webTestClient = WebTestClient.bindToController(paymentController).build();

        webTestClient.post()
               .uri("/payments")
               .bodyValue(paymentRequest)
               .exchange()
               .expectStatus().isOk()
               .expectBody(PaymentResponse.class).isEqualTo(paymentResponse);
    }

    @Test
    void processPayment_shouldReturnRejectedResponse() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");
        PaymentResponse paymentResponse = PaymentResponse.rejected("123", "rejected");

        when(paymentUseCase.processPayment(paymentRequest)).thenReturn(Mono.just(paymentResponse));

        webTestClient = WebTestClient.bindToController(paymentController).build();

        webTestClient.post()
               .uri("/payments")
               .bodyValue(paymentRequest)
               .exchange()
               .expectStatus().isOk()
               .expectBody(PaymentResponse.class).isEqualTo(paymentResponse);
    }

    @Test
    void processPayment_shouldHandleAuthentication() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");

        webTestClient = WebTestClient.bindToController(paymentController).build();

        webTestClient.post()
               .uri("/payments")
               .bodyValue(paymentRequest)
               .exchange()
               .expectStatus().isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    void processPayment_shouldHandleErrors() {
        PaymentRequest paymentRequest = new PaymentRequest("123", "credit", "456");

        when(paymentUseCase.processPayment(paymentRequest)).thenReturn(Mono.error(new RuntimeException("Payment processing failed")));

        webTestClient = WebTestClient.bindToController(paymentController).build();

        webTestClient.post()
               .uri("/payments")
               .bodyValue(paymentRequest)
               .exchange()
               .expectStatus().isInternalServerError();
    }
}