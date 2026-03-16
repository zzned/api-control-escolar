package com.example.apiescolar.repository;

import com.example.apiescolar.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    Optional<Alumno> findByMatricula(String matricula);
}