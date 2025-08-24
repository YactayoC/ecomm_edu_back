package com.pe.proyecteduback.controllers;

import com.pe.proyecteduback.dtos.ProveedorRequestDTO;
import com.pe.proyecteduback.dtos.ProveedorResponseDTO;
import com.pe.proyecteduback.services.ProveedorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public ResponseEntity<List<ProveedorResponseDTO>> listarProveedores() {
        return ResponseEntity.ok(proveedorService.listarProveedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponseDTO> obtenerProveedor(@PathVariable Long id) {
        return ResponseEntity.ok(proveedorService.obtenerProveedorPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProveedorResponseDTO> crearProveedor(
            @Valid @RequestBody ProveedorRequestDTO request) {
        return ResponseEntity.ok(proveedorService.crearProveedor(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorResponseDTO> actualizarProveedor(
            @PathVariable Long id,
            @Valid @RequestBody ProveedorRequestDTO request) {
        return ResponseEntity.ok(proveedorService.actualizarProveedor(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }
}
