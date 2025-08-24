package com.pe.proyecteduback.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
}
