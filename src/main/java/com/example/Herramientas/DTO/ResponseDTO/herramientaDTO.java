package com.example.Herramientas.DTO.ResponseDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record herramientaDTO (
        @NotBlank(message = "el nombre es obligatorio") String nombre,
        @NotBlank(message = "la categoria es obligatoria") String categoria,
        @NotNull(message = "especificar la cantidad") Integer cantidad
){}
