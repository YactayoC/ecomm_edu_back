package com.pe.proyecteduback.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private Long categoriaId;
    private String categoriaNombre;
    private Long proveedorId;
    private String proveedorNombre;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
