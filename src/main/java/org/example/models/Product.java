package org.example.models;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCodigo")
    Long idCodigo;

    @Column(name = "nombreProducto", nullable = false, length = 30)
    String nombreProducto;

    @Column(name = "descripcion", nullable = false, length = 250)
    String descripcion;

    @Column(name = "stock", nullable = false, length = 30)
    int stock;

    @Column(name = "precio", nullable = false, length = 30)
    Double precio;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;

    @OneToMany(mappedBy = "product")
    private List<DetalleDeFactura> detallesDeFactura = new ArrayList<>();



    @PrePersist
    public void prePersist() {
        fechaActualizacion = LocalDateTime.now();
    }

}
