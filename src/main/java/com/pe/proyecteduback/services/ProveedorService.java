package com.pe.proyecteduback.services;

import com.pe.proyecteduback.dtos.ProveedorRequestDTO;
import com.pe.proyecteduback.dtos.ProveedorResponseDTO;

import java.util.List;

public interface ProveedorService {
    ProveedorResponseDTO crearProveedor(ProveedorRequestDTO request);
    ProveedorResponseDTO actualizarProveedor(Long id, ProveedorRequestDTO request);
    void eliminarProveedor(Long id);
    ProveedorResponseDTO obtenerProveedorPorId(Long id);
    List<ProveedorResponseDTO> listarProveedores();
}
