package com.example.apiescolar.repository;

import com.example.apiescolar.model.Calificacion;
import com.example.apiescolar.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    List<Calificacion> findByAlumno(Alumno alumno);
    List<Calificacion> findByAlumnoId(Long alumnoId);
}


