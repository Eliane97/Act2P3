package org.example.services;


import org.example.Repositories.UserRepository;
import org.example.models.Login;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository usuarioRepository;

    public String verificarExistenciaUsuario(User usuario) {
        if (usuarioRepository.existsByNombreUsuario(usuario.getNombreUsuario())) {
            return "Error: El usuario ya existe en la base de datos.";
        } else {
            usuarioRepository.save(usuario);
            return "Usuario guardado exitosamente.";
        }

    }
    public User getUser(String nombreUsuario) {
        Optional<User> optionalUser = usuarioRepository.findByNombreUsuario(nombreUsuario);
        return optionalUser.orElse(null);
    }
    public String verificarAcceso(Login login){

        User user =  getUser(login.getNombreUsuario());

        if (user != null){
            if (user.getContrasena().equals(login.getContrasena()) && user.getRol().contains("admin")||user.getRol().contains("vendedor")){
                return "Inicio de sesion Exitoso";
            }
            else {
                return "Error,su contraseña incorrecta o su rol no tiene acceso al sistema";
            }
        }
        return String.format("Error, el usuario  no existe, por favor registrese");
    }



}


