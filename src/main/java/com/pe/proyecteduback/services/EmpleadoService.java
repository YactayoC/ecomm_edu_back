package com.pe.proyecteduback.services;

import com.pe.proyecteduback.dtos.EmpleadoRequestDTO;
import com.pe.proyecteduback.dtos.EmpleadoResponseDTO;

import java.util.List;

public interface EmpleadoService {
    EmpleadoResponseDTO crearEmpleado(EmpleadoRequestDTO request);
    EmpleadoResponseDTO actualizarEmpleado(Long id, EmpleadoRequestDTO request);
    void eliminarEmpleado(Long id);
    EmpleadoResponseDTO obtenerEmpleadoPorId(Long id);
    List<EmpleadoResponseDTO> listarEmpleados();
}
