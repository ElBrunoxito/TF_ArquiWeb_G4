package com.grupo4.trabajofinal.service;


import com.upc.tp_alejandroversion.dto.PaisDto;
import com.upc.tp_alejandroversion.dto.UsuarioDto;
import com.upc.tp_alejandroversion.model.Pais;
import com.upc.tp_alejandroversion.model.Usuario;
import com.upc.tp_alejandroversion.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario Add(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario(usuarioDto.getNombreUsuario(), usuarioDto.getApellidoUsuario(), usuarioDto.getEmailUsuario(), usuarioDto.getContrasena(), usuarioDto.getFechaRegistro(), usuarioDto.getDireccionUsuario(), usuarioDto.getTelefonoUsuario());
        return usuarioRepository.save(usuario);
    }
    public UsuarioDto GetById(int id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario==null)
            return null;
        UsuarioDto usuarioDto = new UsuarioDto(usuario.getId(), usuario.getNombreUsuario(), usuario.getApellidoUsuario(), usuario.getEmailUsuario(), usuario.getContrasena(), usuario.getFechaRegistro(), usuario.getDireccionUsuario(), usuario.getTelefonoUsuario());
        return usuarioDto;
    }
    public List<UsuarioDto> getAll() {
        List<Usuario> lista = usuarioRepository.findAll();
        List<UsuarioDto> listaDto = new ArrayList<>();
        UsuarioDto item;
        for(Usuario u: lista){
            item = new UsuarioDto(u.getId(),u.getNombreUsuario(), u.getApellidoUsuario(), u.getEmailUsuario(), u.getContrasena(), u.getFechaRegistro(), u.getDireccionUsuario(), u.getTelefonoUsuario());
            listaDto.add(item);
        }
        return listaDto;
    }
}
