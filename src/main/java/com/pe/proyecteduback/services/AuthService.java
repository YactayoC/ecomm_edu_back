package com.pe.proyecteduback.services;

import com.pe.proyecteduback.dtos.auth.LoginRequestDTO;
import com.pe.proyecteduback.dtos.auth.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO request);
}
