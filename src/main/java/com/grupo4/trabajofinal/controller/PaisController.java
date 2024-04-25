package com.grupo4.trabajofinal.controller;

import com.grupo4.trabajofinal.dto.PaisDto;
import com.grupo4.trabajofinal.model.Pais;
import com.grupo4.trabajofinal.model.Usuario;
import com.grupo4.trabajofinal.service.PaisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {
    final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping
    public ResponseEntity<List<PaisDto>> getAll() {
        return new ResponseEntity<>(paisService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PaisDto> GetById(@PathVariable ("id") Integer id) {
        PaisDto paisDto = paisService.GetById(id);
        if (paisDto == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(paisDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pais> Add(@RequestBody PaisDto paisDto){
        return new ResponseEntity<>(paisService.Add(paisDto), HttpStatus.CREATED);
    }
}
