package org.example.controllers;

import org.example.models.Login;
import org.example.services.UserService;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api") // Ruta base para todos los endpoints en este controlador
public class AuthController {
    @Autowired
    private UserService service;

    @PostMapping("/registry")// url completa: http://localhost:8090/registry
    public ResponseEntity<String> registrarUsuario(@RequestBody User usuario) {
        String respuesta = service.verificarExistenciaUsuario(usuario);
        if (respuesta.contains("Error")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(respuesta);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login) {
        String respuesta = service.verificarAcceso(login);
        if (respuesta.contains("Error")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(respuesta);
        }

        return ResponseEntity.ok(respuesta);

    }

}