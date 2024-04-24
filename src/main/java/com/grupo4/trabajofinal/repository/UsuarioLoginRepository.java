package com.grupo4.trabajofinal.repository;

import com.grupo4.trabajofinal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioLoginRepository extends JpaRepository <Usuario,Integer> {
    Usuario findByUsuario(String usuario);
}
