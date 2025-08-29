package com.pe.proyecteduback.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Email(message = "El email no tiene un formato válido")
    private String email;

//    @NotBlank(message = "La contraseña no puede estar vacía")
//    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
//    private String password;

    @NotNull(message = "El rol es obligatorio")
    private Long rolId;
}