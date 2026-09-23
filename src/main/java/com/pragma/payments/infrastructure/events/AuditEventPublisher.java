package com.pragma.payments.infrastructure.events;

import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.SnsException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuditEventPublisher {

    private final SnsClient snsClient;

    public AuditEventPublisher(SnsClient snsClient) {
        this.snsClient = snsClient;
    }

    public Mono<Void> publishAuditEvent(PaymentRequest paymentRequest, PaymentResponse paymentResponse) {
        AuditEvent auditEvent = new AuditEvent(paymentRequest, paymentResponse);
        String message = auditEvent.toString();
        PublishRequest publishRequest = PublishRequest.builder()
               .topicArn("arn:aws:sns:us-east-1:123456789012:payment-audit")
               .message(message)
               .build();

        return Mono.fromFuture(snsClient.publish(publishRequest))
               .then();
    }
}