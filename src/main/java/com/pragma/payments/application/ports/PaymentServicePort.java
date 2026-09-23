package com.pragma.payments.application.ports;

import com.pragma.payments.domain.model.PaymentRequest;
import com.pragma.payments.domain.model.PaymentResponse;
import reactor.core.publisher.Mono;

/**
 * Puerto definido por el dominio para procesar pagos de manera reactiva.
 * La implementación de este puerto será proporcionada por la capa de infraestructura.
 */
public interface PaymentServicePort {
    /**
     * Procesa una solicitud de pago, aplicando las reglas de negocio y validaciones.
     * 
     * @param paymentRequest la solicitud de pago que incluye los datos del pago y la clave de idempotencia.
     * @return un Mono que emite la respuesta del pago con el estado y detalles de la transacción.
     * @throws com.pragma.payments.domain.exception.PaymentProcessingException si ocurre un error durante el procesamiento.
     * @throws com.pragma.payments.domain.exception.TimeoutException si el procesamiento excede el tiempo límite.
     * @throws com.pragma.payments.domain.exception.IdempotencyException si se detecta un intento de procesamiento duplicado.
     */
    Mono<PaymentResponse> processPayment(PaymentRequest paymentRequest);
}