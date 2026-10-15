package com.example.Herramientas.Mapper;

import com.example.Herramientas.DTO.ResponseDTO.prestamoDTO;
import com.example.Herramientas.Entity.Herramienta;
import com.example.Herramientas.Entity.Prestamo;

public class prestamoMapper {
    public static Prestamo toEntity(prestamoDTO dto, Herramienta herramienta) {
        Prestamo prestamo = new Prestamo();

        prestamo.setResponsable(dto.responsable());
        prestamo.setFechaPrestamo(dto.fechaPrestamo());
        prestamo.setCantidad(dto.cantidad());
        prestamo.setHerramienta(herramienta);

        return prestamo;
    }

    public static prestamoDTO toDTO(Prestamo prestamo) {
        return new prestamoDTO(
                prestamo.getResponsable(),
                prestamo.getFechaPrestamo(),
                prestamo.getCantidad(),
                prestamo.getHerramienta().getId()
        );
    }
}
