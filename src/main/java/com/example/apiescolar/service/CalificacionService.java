package com.example.apiescolar.service;

import com.example.apiescolar.model.Calificacion;
import com.example.apiescolar.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    public List<Calificacion> obtenerTodos() {
        return calificacionRepository.findAll();
    }

    public List<Calificacion> obtenerPorAlumno(Long alumnoId) {
        return calificacionRepository.findByAlumnoId(alumnoId);
    }

    public Optional<Calificacion> obtenerPorId(Long id) {
        return calificacionRepository.findById(id);
    }

    public Calificacion guardar(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    public Calificacion actualizar(Long id, Calificacion calificacion) {
        calificacion.setId(id);
        return calificacionRepository.save(calificacion);
    }

    public void eliminar(Long id) {
        calificacionRepository.deleteById(id);
    }
}