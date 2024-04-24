package com.grupo4.trabajofinal.service;

import com.grupo4.trabajofinal.dto.UsuarioLoginDto;
import com.grupo4.trabajofinal.model.Usuario;
import com.grupo4.trabajofinal.repository.UsuarioLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioLoginService {
    @Autowired
    private UsuarioLoginRepository usuarioLoginRepository;
    public Usuario login(UsuarioLoginDto usuarioLoginDto){
        String usuario = usuarioLoginDto.getUsuario();
        String contrasena = usuarioLoginDto.getContrasena();

        Usuario usuarioEncontrado = usuarioLoginRepository.findByUsuario(usuario);
        if (usuarioEncontrado != null && usuarioEncontrado.getContrasena().equals(contrasena)) {
            return usuarioEncontrado;
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }


}
