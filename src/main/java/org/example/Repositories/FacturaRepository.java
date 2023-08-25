package org.example.Repositories;

import org.example.models.DetalleDeFactura;
import org.example.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacturaRepository extends JpaRepository <Factura, Long> {

    Optional<Factura> findByIdFactura(Long idFactura);
    boolean existsByIdFactura(Long idFactura);
}

