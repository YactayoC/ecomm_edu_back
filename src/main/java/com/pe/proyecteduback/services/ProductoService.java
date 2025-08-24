package com.pe.proyecteduback.services;

import com.pe.proyecteduback.dtos.ProductoRequestDTO;
import com.pe.proyecteduback.dtos.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {
    ProductoResponseDTO crearProducto(ProductoRequestDTO request);
    ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO request);
    void eliminarProducto(Long id);
    ProductoResponseDTO obtenerProductoPorId(Long id);
    List<ProductoResponseDTO> listarProductos();
}