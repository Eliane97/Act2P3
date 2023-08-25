package org.example.controllers;

import org.example.models.Cliente;
import org.example.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @PostMapping("/createCliente")
    public ResponseEntity<String> crearCliente(@RequestBody Cliente cliente) {

        String respuesta = service.verificarExistenciaCliente(cliente);

        if (respuesta.contains("El cliente no existe")) {
            String respuesta2 = service.crearCliente(cliente);
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(respuesta2);
        }
        if (respuesta.contains("El cliente ya existe")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(respuesta);
        }
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno");

    }

    @PutMapping("/updateCliente")
    public ResponseEntity<String> actualizarCliente(@RequestBody Cliente cliente) {

        String respuesta = service.actualizarCliente(cliente);

        if (respuesta.contains("Se actualizó el cliente")) {
            return ResponseEntity.status(HttpStatus.OK).body("El cliente a sido actualizado");
        }
        if (respuesta.contains("No se pudo actualizar el cliente")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(respuesta);

        }

        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno");
    }




    @DeleteMapping("/deleteCliente")
    public ResponseEntity<String> eliminarCliente(@RequestBody Cliente cliente) {
        String respuesta = service.eliminarClientePorId(cliente);

        if (respuesta.contains("Cliente eliminado exitosamente")) {
            return ResponseEntity.status(HttpStatus.OK).body("Cliente eliminado exitosament");
        }
        if (respuesta.contains("No se encontró el cliente a eliminar")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("No se encontró el cliente a eliminar");

        }
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno");
    }
/*
    @GetMapping("/obtener")
    public ResponseEntity<String> obtenerClientes(@RequestBody Cliente cliente) {


    }*/
}