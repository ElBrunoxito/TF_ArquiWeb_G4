package com.upc.tp_alejandroversion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Integer id;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String contrasena;
    private Date fechaRegistro = new Date();
    private String direccionUsuario;
    private String telefonoUsuario;
}
