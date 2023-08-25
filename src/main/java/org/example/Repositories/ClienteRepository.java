package org.example.Repositories;

import org.example.models.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

   Optional<Cliente> findByNombreClienteIgnoreCase(String nombreCliente);
    boolean existsByNombreClienteIgnoreCase(String nombreCliente);
}
