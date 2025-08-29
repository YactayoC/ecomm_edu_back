package com.pe.proyecteduback.services.impl;

import com.pe.proyecteduback.dtos.auth.LoginRequestDTO;
import com.pe.proyecteduback.dtos.auth.LoginResponseDTO;
import com.pe.proyecteduback.entities.Empleado;
import com.pe.proyecteduback.repositories.EmpleadoRepository;
import com.pe.proyecteduback.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final EmpleadoRepository empleadoRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        Empleado empleado = empleadoRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), empleado.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return new LoginResponseDTO(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getEmail(),
                empleado.getRol() != null ? empleado.getRol().getNombre() : null
        );
    }
}
