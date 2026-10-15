package com.example.Herramientas.Controller;

import com.example.Herramientas.DTO.ResponseDTO.herramientaDTO;
import com.example.Herramientas.DTO.ResponseDTO.herramientaResponseDTO;
import com.example.Herramientas.Service.ServiceIMP.serviceHerramienta;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
@AllArgsConstructor
public class herramientaController {

    private final serviceHerramienta serviceHerramienta;

    // POST /api/herramientas
    @PostMapping
    public ResponseEntity<herramientaResponseDTO> registrarHerramienta(
            @Valid @RequestBody herramientaDTO dto) {

        herramientaResponseDTO response =
                serviceHerramienta.registrarHerramineta(dto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<herramientaResponseDTO>> consultarHerramientas() {

        List<herramientaResponseDTO> response =
                serviceHerramienta.consultarHerramineta();

        return ResponseEntity.ok(response);
    }
}
