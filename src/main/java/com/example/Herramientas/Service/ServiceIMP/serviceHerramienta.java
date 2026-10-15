package com.example.Herramientas.Service.ServiceIMP;

import com.example.Herramientas.DTO.ResponseDTO.herramientaDTO;
import com.example.Herramientas.DTO.ResponseDTO.herramientaResponseDTO;

import java.util.List;

public interface serviceHerramienta {
     herramientaResponseDTO registrarHerramineta(herramientaDTO dto);
    List<herramientaResponseDTO> consultarHerramineta();
}
