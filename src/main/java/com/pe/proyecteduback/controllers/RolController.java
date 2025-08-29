package com.pe.proyecteduback.controllers;

import com.pe.proyecteduback.dtos.RolResponseDTO;
import com.pe.proyecteduback.services.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolResponseDTO>> listarCategorias() {
        return ResponseEntity.ok(rolService.listarRoles());
    }
}
