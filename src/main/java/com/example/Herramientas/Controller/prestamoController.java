package com.example.Herramientas.Controller;

import com.example.Herramientas.DTO.ResponseDTO.prestamoDTO;
import com.example.Herramientas.DTO.ResponseDTO.prestamoResponseDTO;
import com.example.Herramientas.Service.ServiceIMP.prestamoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@AllArgsConstructor
public class prestamoController {

    private final prestamoService prestamoService;

    @PostMapping
    public ResponseEntity<prestamoResponseDTO> registrar(
            @Valid @RequestBody prestamoDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(prestamoService.registrarPrestamo(dto));
    }

    @GetMapping
    public ResponseEntity<List<prestamoResponseDTO>> consultarTodos() {

        return ResponseEntity.ok(
                prestamoService.consultarTodosLosPrestamos());
    }

    @GetMapping("/herramienta/{id}")
    public ResponseEntity<List<prestamoResponseDTO>>
    consultarPorHerramienta(@PathVariable Long id) {
        return ResponseEntity.ok(
                prestamoService.consultarPrestamosPorHerramienta(id));
    }
}
