package com.example.Herramientas.Service.ServiceIMP;

import com.example.Herramientas.DTO.ResponseDTO.prestamoDTO;
import com.example.Herramientas.DTO.ResponseDTO.prestamoResponseDTO;

import java.util.List;

public interface prestamoService {
    prestamoResponseDTO registrarPrestamo(prestamoDTO dto);
    List<prestamoResponseDTO> consultarTodosLosPrestamos();
    List<prestamoResponseDTO> consultarPrestamosPorHerramienta(Long id);

}
