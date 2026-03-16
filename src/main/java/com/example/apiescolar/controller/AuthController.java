package com.example.apiescolar.controller;

import com.example.apiescolar.config.JwtUtil;
import com.example.apiescolar.dto.LoginRequest;
import com.example.apiescolar.dto.LoginResponse;
import com.example.apiescolar.dto.RegisterRequest;
import com.example.apiescolar.model.Usuario;
import com.example.apiescolar.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (usuarioService.buscarPorUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("El usuario ya existe");
        }
        Usuario usuario = usuarioService.registrar(
            request.getUsername(),
            request.getPassword(),
            request.getRol()
        );
        return ResponseEntity.ok("Usuario registrado: " + usuario.getUsername());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return usuarioService.buscarPorUsername(request.getUsername())
            .filter(u -> usuarioService.validarPassword(request.getPassword(), u.getPassword()))
            .map(u -> {
                String token = jwtUtil.generateToken(u.getUsername(), u.getRol().name());
                return ResponseEntity.ok(new LoginResponse(token, u.getUsername(), u.getRol().name()));
            })
            .orElse(ResponseEntity.status(401).build());
    }
}