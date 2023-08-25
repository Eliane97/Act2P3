package org.example.services;

import org.example.Repositories.ClienteRepository;
import org.example.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;


    public String verificarExistenciaCliente(Cliente cliente) {

        if (clienteRepository.existsByNombreClienteIgnoreCase(cliente.getNombreCliente())) {
            return "El cliente ya existe";
        }
        return "El cliente no existe";
    }

    public String crearCliente (Cliente cliente){
    clienteRepository.save(cliente);
    return "cliente creado";

    }

    public String eliminarClientePorId(Cliente cliente) {

        Optional<Cliente> optionalCliente= clienteRepository.findById(cliente.getIdCliente());

        if (optionalCliente.isPresent()) {
            cliente = optionalCliente.get();
            clienteRepository.delete(cliente);
            return "Cliente eliminado exitosamente";
        } else {
            return "No se encontró el cliente a eliminar";
        }
    }


    public String actualizarCliente (Cliente cliente) {

        Optional<Cliente> optionalCliente = clienteRepository.findById(cliente.getIdCliente());

        if (optionalCliente.isPresent()) {
            Cliente clienteActualizado = optionalCliente.get();
            clienteActualizado.setIdCliente(cliente.getIdCliente());
            clienteActualizado.setCuitCliente(cliente.getCuitCliente());
            clienteActualizado.setDireccionCliente(cliente.getDireccionCliente());
            clienteActualizado.setNombreCliente(cliente.getNombreCliente());
            clienteActualizado.setTelefonoCliente(cliente.getTelefonoCliente());
            clienteActualizado.setDniCliente(cliente.getDniCliente());
            clienteRepository.save(clienteActualizado);
            return "Se actualizó el cliente";
        } else {
            return "No se pudo actualizar el cliente";
        }
    }

    public String mostrarClientes(Cliente cliente) {
     return "";
    }
}
