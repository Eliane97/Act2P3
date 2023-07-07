package org.example.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idUsuario")
    private Long idUsuario;

    @Column(name ="nombreUsurio",nullable = false,length = 30)
    private String nombreUsuario;

    @Column(name="contrasena", nullable = false,length = 120)
    private String contrasena;

    @Column(name="rol", nullable = false,length = 120)
    private String rol;

}