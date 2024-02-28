package com.medical.Medical.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private long Id;

    @Getter @Setter @Column(name = "nombre")
    private String Nombre;

    @Getter @Setter @Column(name = "apellido")
    private String Apellido;

    @Getter @Setter @Column(name = "numero")
    private int Numero;

    @Getter @Setter @Column(name = "contra")
    private String Contraseña;
}
