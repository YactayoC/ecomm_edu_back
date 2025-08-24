package com.pe.proyecteduback.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolRequestDTO {

    @NotBlank(message = "El nombre del rol es obligatorio")
    private String nombre;

    private String descripcion;
}
