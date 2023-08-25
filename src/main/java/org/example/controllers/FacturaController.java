package org.example.controllers;

import org.example.models.Factura;
import org.example.models.Product;
import org.example.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @PostMapping("/createFactura")
    public ResponseEntity<String> crearFactura(@RequestBody Factura factura) {

        String respuesta = facturaService.verificarDigitos(factura);

        if (respuesta.contains("Ingrese solo hasta 4 numeros y hasta 8 numeros luego")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(respuesta);
        }/*
        if (respuesta.contains("el precio del producto no puede ser negativo")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(respuesta);
        }
        if (respuesta.contains("Producto guardado exitosamente")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
        }*/
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno");

    }




}
