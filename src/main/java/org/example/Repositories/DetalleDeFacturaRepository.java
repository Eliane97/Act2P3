package org.example.Repositories;


import org.example.models.DetalleDeFactura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DetalleDeFacturaRepository extends JpaRepository<DetalleDeFactura, Long> {

    Optional<DetalleDeFactura> idDetalleDeFactura(Integer idDetalleDeFactura);
    boolean existsByidDetalleDeFactura(Integer idDetalleDeFactura);
}
