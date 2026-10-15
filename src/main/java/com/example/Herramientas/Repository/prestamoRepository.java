package com.example.Herramientas.Repository;

import com.example.Herramientas.Entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface prestamoRepository extends JpaRepository<Prestamo,Long> {
    List<Prestamo> findByHerramientaId(Long id);
}
