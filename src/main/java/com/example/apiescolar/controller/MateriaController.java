package com.example.apiescolar.controller;

import com.example.apiescolar.model.Materia;
import com.example.apiescolar.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<Materia> obtenerTodos() {
        return materiaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> obtenerPorId(@PathVariable Long id) {
        return materiaService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Materia crear(@RequestBody Materia materia) {
        return materiaService.guardar(materia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> actualizar(@PathVariable Long id, @RequestBody Materia materia) {
        return materiaService.obtenerPorId(id)
            .map(m -> ResponseEntity.ok(materiaService.actualizar(id, materia)))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        return materiaService.obtenerPorId(id)
            .map(m -> {
                materiaService.eliminar(id);
                return ResponseEntity.ok().body("Materia eliminada");
            })
            .orElse(ResponseEntity.notFound().build());
    }
}