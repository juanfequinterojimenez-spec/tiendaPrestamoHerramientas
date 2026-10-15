package com.example.Herramientas.DTO.ResponseDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record prestamoDTO (
        @NotBlank(message = "poner nombre del responsable de la herramienta") String responsable,
        @NotNull(message = "la fecha es obligatoria")LocalDate fechaPrestamo,
        @Min(value = 1, message = "la cantidad debe ser al menos 1")
        Integer cantidad,
        @NotNull(message = "id de la herramienta")
        Long herramientaId
        ){

}
