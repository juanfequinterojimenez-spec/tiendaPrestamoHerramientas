package com.example.Herramientas.Service.ServiceIMP;

import com.example.Herramientas.DTO.ResponseDTO.prestamoDTO;
import com.example.Herramientas.DTO.ResponseDTO.prestamoResponseDTO;
import com.example.Herramientas.Entity.Herramienta;
import com.example.Herramientas.Entity.Prestamo;
import com.example.Herramientas.Repository.herramientaRepository;
import com.example.Herramientas.Repository.prestamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class prestamoServiceIMP implements prestamoService {
    private final prestamoRepository prestamoRepository;
    private final herramientaRepository herramientaRepository;

    @Override
    @Transactional
    public prestamoResponseDTO registrarPrestamo(prestamoDTO dto) {
        Herramienta herramienta = herramientaRepository.findById(dto.herramientaId())
                .orElseThrow(() -> new RuntimeException("Herramienta no encontrada con ID: " + dto.herramientaId()));

        Prestamo prestamo = new Prestamo();
        prestamo.setResponsable(dto.responsable());
        prestamo.setFechaPrestamo(dto.fechaPrestamo());
        prestamo.setCantidad(dto.cantidad());
        prestamo.setHerramienta(herramienta);

        Prestamo saved = prestamoRepository.save(prestamo);

        return new prestamoResponseDTO(
                saved.getId(),
                saved.getHerramienta().getId(),
                saved.getResponsable(),
                saved.getFechaPrestamo(),
                saved.getCantidad()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<prestamoResponseDTO> consultarTodosLosPrestamos() {
        return prestamoRepository.findAll().stream()
                .map(p -> new prestamoResponseDTO(
                        p.getId(),
                        p.getHerramienta().getId(),
                        p.getResponsable(),
                        p.getFechaPrestamo(),
                        p.getCantidad()
                ))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<prestamoResponseDTO> consultarPrestamosPorHerramienta(Long id) {
        if (!herramientaRepository.existsById(id)) {
            throw new RuntimeException(
                    "Herramienta no encontrada con ID: " + id);
        }
        return prestamoRepository.findByHerramientaId(id).stream()
                .map(p -> new prestamoResponseDTO(
                        p.getId(),
                        p.getHerramienta().getId(),
                        p.getResponsable(),
                        p.getFechaPrestamo(),
                        p.getCantidad()
                ))
                .collect(Collectors.toList());
    }
}
