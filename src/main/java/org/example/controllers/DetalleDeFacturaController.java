package org.example.controllers;

import org.example.services.DetalleDeFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DetalleDeFacturaController {
    @Autowired
    private DetalleDeFacturaService detalleDeFacturaService;
}
