package com.pe.proyecteduback.services;

import com.pe.proyecteduback.dtos.CategoriaRequestDTO;
import com.pe.proyecteduback.dtos.CategoriaResponseDTO;

import java.util.List;

public interface CategoriaService {
    CategoriaResponseDTO crearCategoria(CategoriaRequestDTO request);
    CategoriaResponseDTO actualizarCategoria(Long id, CategoriaRequestDTO request);
    void eliminarCategoria(Long id);
    CategoriaResponseDTO obtenerCategoriaPorId(Long id);
    List<CategoriaResponseDTO> listarCategorias();
}
