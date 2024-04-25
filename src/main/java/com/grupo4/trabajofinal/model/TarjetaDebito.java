package com.grupo4.trabajofinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaDebito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numeroTarjeta;
    private Date fechaVencimiento;
    private Integer cvv;
    private Integer claveDigital;
    //relacion de 1 a 1 de TG con usuario
    @OneToOne
    @JoinColumn (name = "usuario_id")
    Usuario usuario;
    // relacion de 1 a muchos de TD con transacciones
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "tarjetaDebito")
    private List<Transaccion> transacciones;

    //relacion banco
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "banco_id")
    Banco banco;
}
