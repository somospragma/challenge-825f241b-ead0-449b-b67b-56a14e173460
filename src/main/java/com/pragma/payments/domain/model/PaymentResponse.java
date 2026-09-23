package com.pragma.payments.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Modelo de dominio que representa la respuesta de un pago procesado.
 * Contiene el estado de la transacción y detalles relevantes.
 */
public record PaymentResponse(
    UUID paymentId,
    String operationNumber,
    String status,
    String statusDetail,
    BigDecimal amount,
    String currency,
    LocalDateTime responseTimestamp,
    String fraudCheckStatus,
    String riskBureauStatus,
    String coreBankingStatus
) {
    /**
     * Constructor compacto para crear una respuesta de pago.
     * 
     * @param paymentId identificador único del pago.
     * @param operationNumber número de operación.
     * @param status estado general del pago (ej: "ACCEPTED", "REJECTED", "PENDING").
     * @param statusDetail detalle adicional del estado.
     * @param amount monto del pago.
     * @param currency moneda del pago.
     * @param responseTimestamp marca de tiempo de la respuesta.
     * @param fraudCheckStatus estado de la verificación antifraude.
     * @param riskBureauStatus estado del buró de riesgos.
     * @param coreBankingStatus estado del core bancario.
     * @throws IllegalArgumentException si alguno de los campos requeridos es nulo o vacío.
     */
    public PaymentResponse {
        if (paymentId == null) {
            throw new IllegalArgumentException("El paymentId no puede ser nulo");
        }
        if (operationNumber == null || operationNumber.isBlank()) {
            throw new IllegalArgumentException("El operationNumber no puede ser nulo o vacío");
        }
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("El status no puede ser nulo o vacío");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El amount debe ser un valor positivo");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("La currency no puede ser nula o vacía");
        }
        if (responseTimestamp == null) {
            throw new IllegalArgumentException("El responseTimestamp no puede ser nulo");
        }
    }

    /**
     * Crea una respuesta de pago con estado ACCEPTED.
     * 
     * @param paymentId identificador único del pago.
     * @param operationNumber número de operación.
     * @param amount monto del pago.
     * @param currency moneda del pago.
     * @param fraudCheckStatus estado de la verificación antifraude.
     * @param riskBureauStatus estado del buró de riesgos.
     * @param coreBankingStatus estado del core bancario.
     * @return una instancia de PaymentResponse con estado ACCEPTED y detalles proporcionados.
     */
    public static PaymentResponse accepted(
        UUID paymentId,
        String operationNumber,
        BigDecimal amount,
        String currency,
        String fraudCheckStatus,
        String riskBureauStatus,
        String coreBankingStatus
    ) {
        return new PaymentResponse(
            paymentId,
            operationNumber,
            "ACCEPTED",
            "Pago procesado exitosamente",
            amount,
            currency,
            LocalDateTime.now(),
            fraudCheckStatus,
            riskBureauStatus,
            coreBankingStatus
        );
    }

    /**
     * Crea una respuesta de pago con estado REJECTED.
     * 
     * @param paymentId identificador único del pago.
     * @param operationNumber número de operación.
     * @param statusDetail detalle del motivo de rechazo.
     * @param amount monto del pago.
     * @param currency moneda del pago.
     * @return una instancia de PaymentResponse con estado REJECTED y detalles proporcionados.
     */
    public static PaymentResponse rejected(
        UUID paymentId,
        String operationNumber,
        String statusDetail,
        BigDecimal amount,
        String currency
    ) {
        return new PaymentResponse(
            paymentId,
            operationNumber,
            "REJECTED",
            statusDetail,
            amount,
            currency,
            LocalDateTime.now(),
            null,
            null,
            null
        );
    }

    /**
     * Crea una respuesta de pago con estado PENDING.
     * 
     * @param paymentId identificador único del pago.
     * @param operationNumber número de operación.
     * @param statusDetail detalle del motivo de pendiente.
     * @param amount monto del pago.
     * @param currency moneda del pago.
     * @return una instancia de PaymentResponse con estado PENDING y detalles proporcionados.
     */
    public static PaymentResponse pending(
        UUID paymentId,
        String operationNumber,
        String statusDetail,
        BigDecimal amount,
        String currency
    ) {
        return new PaymentResponse(
            paymentId,
            operationNumber,
            "PENDING",
            statusDetail,
            amount,
            currency,
            LocalDateTime.now(),
            null,
            null,
            null
        );
    }
}