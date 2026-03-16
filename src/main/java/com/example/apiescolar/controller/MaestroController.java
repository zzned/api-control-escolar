package com.example.apiescolar.controller;

import com.example.apiescolar.model.Maestro;
import com.example.apiescolar.service.MaestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maestros")
public class MaestroController {

    @Autowired
    private MaestroService maestroService;

    @GetMapping
    public List<Maestro> obtenerTodos() {
        return maestroService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maestro> obtenerPorId(@PathVariable Long id) {
        return maestroService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Maestro crear(@RequestBody Maestro maestro) {
        return maestroService.guardar(maestro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maestro> actualizar(@PathVariable Long id, @RequestBody Maestro maestro) {
        return maestroService.obtenerPorId(id)
            .map(m -> ResponseEntity.ok(maestroService.actualizar(id, maestro)))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        return maestroService.obtenerPorId(id)
            .map(m -> {
                maestroService.eliminar(id);
                return ResponseEntity.ok().body("Maestro eliminado");
            })
            .orElse(ResponseEntity.notFound().build());
    }
}