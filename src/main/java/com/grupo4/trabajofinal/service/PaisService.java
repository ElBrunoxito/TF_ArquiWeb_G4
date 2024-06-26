package com.grupo4.trabajofinal.service;

import com.grupo4.trabajofinal.dto.PaisDto;
import com.grupo4.trabajofinal.model.Pais;
import com.grupo4.trabajofinal.model.Usuario;
import com.grupo4.trabajofinal.repository.PaisRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaisService {
    final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<PaisDto> getAll() {
        List<Pais> lista = paisRepository.findAll();
        List<PaisDto> listaDto = new ArrayList<>();
        PaisDto item;
        for(Pais p: lista){
            item = new PaisDto(p.getId(),p.getNombrePais());
            listaDto.add(item);
        }
        return listaDto;
    }

    public PaisDto GetById(int id){
        Pais pais = paisRepository.findById(id).orElse(null);
        if(pais==null)
            return null;
        PaisDto paisDto = new PaisDto(pais.getId(), pais.getNombrePais());
        return paisDto;
    }

    public Pais Add(PaisDto paisDto){
        Pais pais = new Pais(paisDto.getNombrePais());
        return paisRepository.save(pais);
    }
}
