package org.example.services;

import org.example.Repositories.FacturaRepository;
import org.example.models.Factura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    public String verificarDigitos(Factura factura) {

        // Limitar el input a 4 caracteres
        if (factura.getNro1Factura().length() > 4 && factura.getNro2Factura().length() > 8) {
            String numero = null;
            numero = numero.substring(0, 4);
            String numero4Formatiado = String.format("%04d", Integer.parseInt(numero));
            numero = numero.substring(0, 8);
            String numero8Formatiado = String.format("%08d", Integer.parseInt(numero));
            Optional<Factura> optionalFactura = facturaRepository.findById(factura.getIdFactura());

            if (optionalFactura.isPresent()) {
                Factura facturaNumerosCompletos = optionalFactura.get();
                facturaNumerosCompletos.setNro1Factura(numero4Formatiado);
                facturaNumerosCompletos.setNro2Factura(numero8Formatiado);
                facturaRepository.save(facturaNumerosCompletos);
            }
            return "Digitos Bien";
        }
         else
        return "Ingrese solo hasta 4 numeros y hasta 8 numeros luego";


    }


}

