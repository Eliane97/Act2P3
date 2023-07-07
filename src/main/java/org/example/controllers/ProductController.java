package org.example.controllers;

import org.example.models.Product;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api") // Ruta base para todos los endpoints en este controlador
public class ProductController {


    @Autowired
    private ProductService service;

    @PostMapping("/create")
    public ResponseEntity<String> crearProducto(@RequestBody Product product) {

        String respuesta = service.verificarPrecioYexistencia(product);

        if (respuesta.contains("Ya existe un producto con el nombre ingresado")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(respuesta);
        }
        if (respuesta.contains("el precio del producto no puede ser negativo")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(respuesta);
        }
        if (respuesta.contains("Producto guardado exitosamente")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
        }
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno");

    }

    @PutMapping("/update")
    public ResponseEntity<String> actualizarProducto(@RequestBody Product product) {

        String respuesta = service.actualizarEntidad(product);

        if (respuesta.contains("Se actualizó el producto")) {
            return ResponseEntity.status(HttpStatus.OK).body("El producto a sido actualizado");
        }
        if (respuesta.contains("No se encontró el producto a actualizar")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(respuesta);

        }
        if (respuesta.contains("Nose puede ingresar un precio negativo")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Nose puede ingresar un precio negativo");
        }
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno");
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> eliminarProducto(@RequestBody Product product) {

        String respuesta = service.eliminarProductoPorId(product);

        if (respuesta.contains("Producto eliminado exitosamente")) {
            return ResponseEntity.status(HttpStatus.OK).body("El producto a sido eliminado correctamente");
        }
        if (respuesta.contains("No se encontró el producto a eliminar")) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("El producto no existe");

        }
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno");
    }
}