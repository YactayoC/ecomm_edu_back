package com.pe.proyecteduback.dtos.auth;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String rol;
}
