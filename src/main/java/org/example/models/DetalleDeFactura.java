package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "DetalleDeFactura")
public class DetalleDeFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idDetalleDeFactura")
    Long idDetalleDeFactura;

    @ManyToOne
    @JoinColumn(name = "idCodigo")
    Product product;

    @Column(name = "cantXproducto", nullable = false, length = 30)
    Integer cantXproducto;

    @Column(name = "precioDelProducto", nullable = false, length = 30)
    Double precioDelProducto;

    @Column(name = "precioTotalProducto", nullable = false, length = 30)
    Double precioTotalProducto;


}
