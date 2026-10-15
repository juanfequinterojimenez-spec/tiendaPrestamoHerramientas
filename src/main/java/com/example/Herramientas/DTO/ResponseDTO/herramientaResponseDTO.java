package com.example.Herramientas.DTO.ResponseDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

public record herramientaResponseDTO(
        Long Id,
        String nombre,
        String categoria,
        Integer cantidad
) {
}
