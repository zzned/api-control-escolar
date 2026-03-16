package com.example.apiescolar.controller;

import com.example.apiescolar.model.Calificacion;
import com.example.apiescolar.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping
    public List<Calificacion> obtenerTodos() {
        return calificacionService.obtenerTodos();
    }

    @GetMapping("/alumno/{alumnoId}")
    public List<Calificacion> obtenerPorAlumno(@PathVariable Long alumnoId) {
        return calificacionService.obtenerPorAlumno(alumnoId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calificacion> obtenerPorId(@PathVariable Long id) {
        return calificacionService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Calificacion crear(@RequestBody Calificacion calificacion) {
        return calificacionService.guardar(calificacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> actualizar(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        return calificacionService.obtenerPorId(id)
            .map(c -> ResponseEntity.ok(calificacionService.actualizar(id, calificacion)))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        return calificacionService.obtenerPorId(id)
            .map(c -> {
                calificacionService.eliminar(id);
                return ResponseEntity.ok().body("Calificacion eliminada");
            })
            .orElse(ResponseEntity.notFound().build());
    }
}