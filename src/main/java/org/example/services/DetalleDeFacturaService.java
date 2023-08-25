package org.example.services;

import org.example.Repositories.DetalleDeFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleDeFacturaService {
    @Autowired
    private DetalleDeFacturaRepository detalleDeFacturaRepository;
}
