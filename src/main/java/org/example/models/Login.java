package org.example.models;

import lombok.*;

// Con libreria lombok puedo ahorra codigo de setters,getters y constructores
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {
    private String nombreUsuario;
    private String contrasena;
}
