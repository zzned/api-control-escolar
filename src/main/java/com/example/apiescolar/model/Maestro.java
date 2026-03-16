package com.example.apiescolar.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "maestros")
public class Maestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String especialidad;
}