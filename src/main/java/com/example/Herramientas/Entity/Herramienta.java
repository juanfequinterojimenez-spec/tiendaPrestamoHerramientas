package com.example.Herramientas.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "herramientas")
@Data
public class Herramienta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String categoria;
    private Integer cantidad;

    @OneToMany(mappedBy = "herramienta")
    private List<Prestamo> prestamos = new ArrayList<>();
}
