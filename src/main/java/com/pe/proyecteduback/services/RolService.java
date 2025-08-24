package com.pe.proyecteduback.services;

import com.pe.proyecteduback.dtos.RolRequestDTO;
import com.pe.proyecteduback.dtos.RolResponseDTO;

import java.util.List;

public interface RolService {
    RolResponseDTO crearRol(RolRequestDTO request);
    RolResponseDTO actualizarRol(Long id, RolRequestDTO request);
    void eliminarRol(Long id);
    RolResponseDTO obtenerRolPorId(Long id);
    List<RolResponseDTO> listarRoles();
}