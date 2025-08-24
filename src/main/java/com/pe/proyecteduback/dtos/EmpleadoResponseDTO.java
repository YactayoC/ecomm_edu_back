package com.pe.proyecteduback.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoResponseDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String rolNombre;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
