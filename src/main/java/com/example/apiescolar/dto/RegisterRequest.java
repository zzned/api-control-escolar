package com.example.apiescolar.dto;

import com.example.apiescolar.model.Usuario;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Usuario.Rol rol;
}