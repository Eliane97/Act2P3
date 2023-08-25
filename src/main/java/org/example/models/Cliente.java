package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table//(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCliente")
    Long idCliente;

    @Column(name = "nombreCliente", nullable = false, length = 30)
    String nombreCliente;
    @Column(name = "dniCliemte", nullable = false)
    private Long dniCliente;

    @Column(name = "cuitCliente", nullable = false)
    private Long cuitCliente;

    @Column(name = "telefonoCliente", nullable = false)
    private Long telefonoCliente;

    @Column(name = "direccionCliente", nullable = false, length = 30)
    String direccionCliente;

}