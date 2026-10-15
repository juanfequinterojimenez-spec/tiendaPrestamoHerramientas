package com.example.Herramientas.Service.ServiceIMP;

import com.example.Herramientas.DTO.ResponseDTO.herramientaDTO;
import com.example.Herramientas.DTO.ResponseDTO.herramientaResponseDTO;
import com.example.Herramientas.Entity.Herramienta;
import com.example.Herramientas.Repository.herramientaRepository;
import com.example.Herramientas.Repository.prestamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class herramientaServiceIMP implements serviceHerramienta {
    private final herramientaRepository herramientaRepository;
    private final prestamoRepository prestamoRepository;

    @Override
    @Transactional
    public herramientaResponseDTO registrarHerramineta(herramientaDTO dto) {
        Herramienta herramienta = new Herramienta();
        herramienta.setNombre(dto.nombre());
        herramienta.setCategoria(dto.categoria());
        herramienta.setCantidad(dto.cantidad());

        Herramienta saved = herramientaRepository.save(herramienta);

        return new herramientaResponseDTO(
                saved.getId(),
                saved.getNombre(),
                saved.getCategoria(),
                saved.getCantidad()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<herramientaResponseDTO> consultarHerramineta() {
        return herramientaRepository.findAll().stream()
                .map(h -> new herramientaResponseDTO(
                        h.getId(),
                        h.getNombre(),
                        h.getCategoria(),
                        h.getCantidad()
                ))
                .collect(Collectors.toList());
    }
}
