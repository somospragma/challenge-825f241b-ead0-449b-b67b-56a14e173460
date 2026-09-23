package com.pragma.payments.infrastructure.adapters;

import com.pragma.payments.application.ports.RiskBureauPort;
import com.pragma.payments.domain.model.RiskAssessment;
import com.pragma.payments.domain.model.RiskRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RiskBureauAdapter implements RiskBureauPort {

    @CircuitBreaker(name = "riskBureau", fallbackMethod = "fallbackRiskAssessment")
    @Retry(name = "riskBureau")
    @RateLimiter(name = "riskBureau")
    @Override
    public Mono<RiskAssessment> assessRisk(RiskRequest riskRequest) {
        // Simulate a call to the risk bureau
        return Mono.just(new RiskAssessment("LOW"));
    }

    public Mono<RiskAssessment> fallbackRiskAssessment(RiskRequest riskRequest, Throwable t) {
        return Mono.just(new RiskAssessment("FALLBACK"));
    }
}