package com.example.Herramientas.DTO.ResponseDTO;

import java.time.LocalDate;

public record prestamoResponseDTO(
        Long id,
        Long herramientaId,
        String responsable,
        LocalDate fechaPrestamo,
        Integer cantidad
) {
}
