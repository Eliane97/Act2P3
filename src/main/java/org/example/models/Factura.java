package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idFactura")
    Long idFactura;

    String Nro1Factura;//(Solo números. Tamaño fijo 4 caracteres, si ingresan menos caracteres completar con ceros a la izquierda)

    String Nro2Factura;//(Solo números, Tamaño Fijo de 8 caracteres, sin ingresan menos completar con ceros a la izquierda)

    @ManyToOne
    @JoinColumn(name = "idCliente")
    Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    User vendedor;
    //DetalleDeFactura detalleDeFactura;//Mínimo debe contener un objeto.
    Double precioTotal;//la suma de los totales de los detalles de factura.

}
