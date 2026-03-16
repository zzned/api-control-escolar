package com.example.apiescolar.service;

import com.example.apiescolar.model.Maestro;
import com.example.apiescolar.repository.MaestroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaestroService {

    @Autowired
    private MaestroRepository maestroRepository;

    public List<Maestro> obtenerTodos() {
        return maestroRepository.findAll();
    }

    public Optional<Maestro> obtenerPorId(Long id) {
        return maestroRepository.findById(id);
    }

    public Maestro guardar(Maestro maestro) {
        return maestroRepository.save(maestro);
    }

    public Maestro actualizar(Long id, Maestro maestro) {
        maestro.setId(id);
        return maestroRepository.save(maestro);
    }

    public void eliminar(Long id) {
        maestroRepository.deleteById(id);
    }
}