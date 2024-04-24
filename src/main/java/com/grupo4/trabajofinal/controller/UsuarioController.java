package com.grupo4.trabajofinal.controller;

import com.grupo4.trabajofinal.dto.UsuarioLoginDto;
import com.grupo4.trabajofinal.model.Usuario;
import com.grupo4.trabajofinal.service.UsuarioLoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    final UsuarioLoginService usuarioLoginService;

    public UsuarioController(UsuarioLoginService usuarioLoginService) {
        this.usuarioLoginService = usuarioLoginService;
    }
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        Usuario usuarioAutenticado = usuarioLoginService.login(usuarioLoginDto);
        return ResponseEntity.ok(usuarioAutenticado);
    }
}
