package com.example.Herramientas.Mapper;

import com.example.Herramientas.DTO.ResponseDTO.herramientaDTO;
import com.example.Herramientas.Entity.Herramienta;

public class herramientaMapper {
    public static Herramienta toEntity(herramientaDTO dto) {
        Herramienta herramienta = new Herramienta();

        herramienta.setNombre(dto.nombre());
        herramienta.setCategoria(dto.categoria());
        herramienta.setCantidad(dto.cantidad());

        return herramienta;
    }

    public static herramientaDTO toDTO(Herramienta herramienta) {
        return new herramientaDTO(
                herramienta.getNombre(),
                herramienta.getCategoria(),
                herramienta.getCantidad()
        );
    }
}