package com.example.apiescolar.service;

import com.example.apiescolar.model.Materia;
import com.example.apiescolar.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<Materia> obtenerTodos() {
        return materiaRepository.findAll();
    }

    public Optional<Materia> obtenerPorId(Long id) {
        return materiaRepository.findById(id);
    }

    public Materia guardar(Materia materia) {
        return materiaRepository.save(materia);
    }

    public Materia actualizar(Long id, Materia materia) {
        materia.setId(id);
        return materiaRepository.save(materia);
    }

    public void eliminar(Long id) {
        materiaRepository.deleteById(id);
    }
}