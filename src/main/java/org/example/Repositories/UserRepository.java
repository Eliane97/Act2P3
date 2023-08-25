package org.example.Repositories;


import org.example.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByNombreUsuario(String nombreUsuario);
    Optional<User> findByNombreUsuario(String nombreUsuario);
/*

    boolean existsByNombreUsuario(String nombreUsuario);



*/
}

