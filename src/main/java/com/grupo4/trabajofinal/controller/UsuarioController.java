package com.grupo4.trabajofinal.controller;

import com.upc.tp_alejandroversion.dto.PaisDto;
import com.upc.tp_alejandroversion.dto.UsuarioDto;
import com.upc.tp_alejandroversion.model.Pais;
import com.upc.tp_alejandroversion.model.Usuario;
import com.upc.tp_alejandroversion.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAll() {
        return new ResponseEntity<>(usuarioService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> GetById(@PathVariable ("id") Integer id) {
        UsuarioDto usuarioDto = usuarioService.GetById(id);
        if (usuarioDto == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Usuario> Add(@RequestBody UsuarioDto usuarioDto){
        return new ResponseEntity<>(usuarioService.Add(usuarioDto), HttpStatus.CREATED);
    }
}
