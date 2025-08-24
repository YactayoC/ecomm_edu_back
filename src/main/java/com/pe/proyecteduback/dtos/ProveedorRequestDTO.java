package com.pe.proyecteduback.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ProveedorRequestDTO {
    @NotBlank(message = "El nombre del proveedor es obligatorio")
    private String nombre;

    private String contacto;

    @Size(max = 20, message = "El teléfono no debe superar los 20 caracteres")
    private String telefono;

    @Email(message = "El email no tiene un formato válido")
    private String email;

    private String direccion;
}
