package com.pe.proyecteduback.controllers;

import com.pe.proyecteduback.dtos.EmpleadoRequestDTO;
import com.pe.proyecteduback.dtos.EmpleadoResponseDTO;
import com.pe.proyecteduback.services.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDTO>> listarEmpleados() {
        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }

    // 🔹 Obtener empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> obtenerEmpleado(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.obtenerEmpleadoPorId(id));
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> crearEmpleado(
            @Valid @RequestBody EmpleadoRequestDTO request) {
        return ResponseEntity.ok(empleadoService.crearEmpleado(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> actualizarEmpleado(
            @PathVariable Long id,
            @Valid @RequestBody EmpleadoRequestDTO request) {
        return ResponseEntity.ok(empleadoService.actualizarEmpleado(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}
