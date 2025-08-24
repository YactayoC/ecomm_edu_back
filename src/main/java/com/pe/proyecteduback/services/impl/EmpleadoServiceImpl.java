package com.pe.proyecteduback.services.impl;

import com.pe.proyecteduback.dtos.EmpleadoRequestDTO;
import com.pe.proyecteduback.dtos.EmpleadoResponseDTO;
import com.pe.proyecteduback.entities.Empleado;
import com.pe.proyecteduback.entities.Rol;
import com.pe.proyecteduback.repositories.EmpleadoRepository;
import com.pe.proyecteduback.repositories.RolRepository;
import com.pe.proyecteduback.services.EmpleadoService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository,
                               RolRepository rolRepository,
                               PasswordEncoder passwordEncoder) {
        this.empleadoRepository = empleadoRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public EmpleadoResponseDTO crearEmpleado(EmpleadoRequestDTO request) {
        Empleado empleado = new Empleado();
        empleado.setNombre(request.getNombre());
        empleado.setApellido(request.getApellido());
        empleado.setEmail(request.getEmail());

        empleado.setPassword(passwordEncoder.encode(request.getPassword()));

        Rol rol = rolRepository.findById(request.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        empleado.setRol(rol);

        empleado = empleadoRepository.save(empleado);
        return mapToResponse(empleado);
    }

    @Override
    public EmpleadoResponseDTO actualizarEmpleado(Long id, EmpleadoRequestDTO request) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleado.setNombre(request.getNombre());
        empleado.setApellido(request.getApellido());
        empleado.setEmail(request.getEmail());

        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            empleado.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        Rol rol = rolRepository.findById(request.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        empleado.setRol(rol);

        empleado = empleadoRepository.save(empleado);
        return mapToResponse(empleado);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        if (!empleadoRepository.existsById(id)) {
            throw new RuntimeException("Empleado no encontrado");
        }
        empleadoRepository.deleteById(id);
    }

    @Override
    public EmpleadoResponseDTO obtenerEmpleadoPorId(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        return mapToResponse(empleado);
    }

    @Override
    public List<EmpleadoResponseDTO> listarEmpleados() {
        return empleadoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private EmpleadoResponseDTO mapToResponse(Empleado empleado) {
        return new EmpleadoResponseDTO(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getEmail(),
                empleado.getRol().getNombre(),
                empleado.getCreatedAt(),
                empleado.getUpdatedAt()
        );
    }
}
