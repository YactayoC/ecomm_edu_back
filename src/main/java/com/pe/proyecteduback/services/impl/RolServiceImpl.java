package com.pe.proyecteduback.services.impl;

import com.pe.proyecteduback.dtos.RolRequestDTO;
import com.pe.proyecteduback.dtos.RolResponseDTO;
import com.pe.proyecteduback.entities.Rol;
import com.pe.proyecteduback.repositories.RolRepository;
import com.pe.proyecteduback.services.RolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public RolResponseDTO crearRol(RolRequestDTO request) {
        Rol rol = new Rol();
        rol.setNombre(request.getNombre());

        rol = rolRepository.save(rol);
        return mapToResponse(rol);
    }

    @Override
    public RolResponseDTO actualizarRol(Long id, RolRequestDTO request) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        rol.setNombre(request.getNombre());

        rol = rolRepository.save(rol);
        return mapToResponse(rol);
    }

    @Override
    public void eliminarRol(Long id) {
        if (!rolRepository.existsById(id)) {
            throw new RuntimeException("Rol no encontrado");
        }
        rolRepository.deleteById(id);
    }

    @Override
    public RolResponseDTO obtenerRolPorId(Long id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        return mapToResponse(rol);
    }

    @Override
    public List<RolResponseDTO> listarRoles() {
        return rolRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private RolResponseDTO mapToResponse(Rol rol) {
        return new RolResponseDTO(
                rol.getId(),
                rol.getNombre(),
                rol.getDescripcion()
        );
    }
}
