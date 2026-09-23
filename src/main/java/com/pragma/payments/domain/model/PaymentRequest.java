package com.pragma.payments.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Modelo de dominio que representa una solicitud de pago.
 * Incluye validaciones de negocio y campos para garantizar idempotencia.
 */
public record PaymentRequest(
    UUID paymentId,
    String operationNumber,
    String channel,
    String customerId,
    String accountFrom,
    String accountTo,
    BigDecimal amount,
    String currency,
    LocalDateTime requestTimestamp,
    String idempotencyKey
) {
    /**
     * Constructor compacto para crear una solicitud de pago con validaciones básicas.
     * 
     * @param paymentId identificador único del pago.
     * @param operationNumber número de operación generado por el canal.
     * @param channel canal desde el cual se origina la solicitud (ej: "MOBILE", "WEB", "POS").
     * @param customerId identificador del cliente.
     * @param accountFrom cuenta de origen del pago.
     * @param accountTo cuenta de destino del pago.
     * @param amount monto del pago.
     * @param currency moneda del pago.
     * @param requestTimestamp marca de tiempo de la solicitud.
     * @param idempotencyKey clave de idempotencia compuesta por operationNumber y channel.
     * @throws IllegalArgumentException si alguno de los campos requeridos es nulo o vacío.
     */
    public PaymentRequest {
        if (paymentId == null) {
            throw new IllegalArgumentException("El paymentId no puede ser nulo");
        }
        if (operationNumber == null || operationNumber.isBlank()) {
            throw new IllegalArgumentException("El operationNumber no puede ser nulo o vacío");
        }
        if (channel == null || channel.isBlank()) {
            throw new IllegalArgumentException("El channel no puede ser nulo o vacío");
        }
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("El customerId no puede ser nulo o vacío");
        }
        if (accountFrom == null || accountFrom.isBlank()) {
            throw new IllegalArgumentException("La accountFrom no puede ser nula o vacía");
        }
        if (accountTo == null || accountTo.isBlank()) {
            throw new IllegalArgumentException("La accountTo no puede ser nula o vacía");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El amount debe ser un valor positivo");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("La currency no puede ser nula o vacía");
        }
        if (requestTimestamp == null) {
            throw new IllegalArgumentException("El requestTimestamp no puede ser nulo");
        }
        if (idempotencyKey == null || idempotencyKey.isBlank()) {
            throw new IllegalArgumentException("La idempotencyKey no puede ser nula o vacía");
        }
    }

    /**
     * Genera una clave de idempotencia a partir del número de operación y el canal.
     * 
     * @param operationNumber número de operación.
     * @param channel canal de origen.
     * @return clave de idempotencia en formato "operationNumber:channel".
     */
    public static String generateIdempotencyKey(String operationNumber, String channel) {
        return operationNumber + ":" + channel;
    }
}