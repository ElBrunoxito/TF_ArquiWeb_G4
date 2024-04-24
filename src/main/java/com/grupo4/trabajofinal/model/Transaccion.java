package com.grupo4.trabajofinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private LocalTime hora;
    private Double monto;
    private String descripcion;
    //relacion 1 a muchos de TD a transaccion
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "tarjetaDebito_Id",nullable = false)
    private TarjetaDebito tarjetaDebito;


}
