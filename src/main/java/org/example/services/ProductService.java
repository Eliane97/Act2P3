package org.example.services;

import org.example.Repositories.ProductRepository;
import org.example.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public String verificarPrecioPositivo(Product product) {

        if(product.getPrecio() >= 0) {return "precio positivo";}

      return "precio negativo";
    }

    public String verificarExistenciaProducto (Product product){

        if (productRepository.existsByNombreProducto(product.getNombreProducto())){
            return "El producto existe";
        }
        return "El producto no exite";

    }

    public String eliminarProductoPorId(Product product) {

        Optional<Product> optionalProduct = productRepository.findById(product.getIdCodigo());

        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
            productRepository.delete(product);
            return "Producto eliminado exitosamente";
        } else {
            return "No se encontró el producto a eliminar";
        }
    }


    public String verificarPrecioYexistencia (Product product) {

        if (verificarExistenciaProducto(product).contains("El producto existe")) {
            return "Ya existe un producto con el nombre ingresado";
        }
        if (verificarPrecioPositivo(product).contains("precio negativo")) {
            return "el precio del producto no puede ser negativo";
        } else {
            productRepository.save(product);
            return "Producto guardado exitosamente";
        }
    }

    public String actualizarEntidad(Product product) {

        if (verificarPrecioPositivo(product).contains("precio negativo")){
            return "Nose puede ingresar un precio negativo";
        }
        Optional<Product> optionalProduct = productRepository.findById(product.getIdCodigo());

        if (optionalProduct.isPresent()) {
            Product productActualizado = optionalProduct.get();
            productActualizado.setNombreProducto(product.getNombreProducto());
            productActualizado.setDescripcion(product.getDescripcion());
            productActualizado.setPrecio(product.getPrecio());
            productActualizado.setStock(product.getStock());
            productActualizado.setFechaActualizacion(LocalDateTime.now());
            productRepository.save(productActualizado);
            return "Se actualizó el producto";
        } else {
            return "No se encontró el producto a actualizar";
        }
    }


}


