package com.grupo4.trabajofinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String email;
    private String contrasena;
    private Date fechaRegistro = new Date();
    private String direccionUsuario;
    private String telefonoUsuario;
    //relacion 1 a muchos de ciudad a usuario
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;
    //relacion de 1 a 1 de usuario y TD
    @OneToOne(mappedBy = "usuario" ,cascade = CascadeType.ALL)
    private TarjetaDebito tarjetaDebito;

}