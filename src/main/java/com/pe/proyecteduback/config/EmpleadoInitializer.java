package com.pe.proyecteduback.config;

import com.pe.proyecteduback.dtos.EmpleadoRequestDTO;
import com.pe.proyecteduback.services.EmpleadoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoInitializer implements CommandLineRunner {
    private final EmpleadoService empleadoService;

    public EmpleadoInitializer(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @Override
    public void run(String... args) {
        String correoAdmin = "admin@gmail.com";
        if (!empleadoService.existePorCorreo(correoAdmin)) {
            EmpleadoRequestDTO admin = new EmpleadoRequestDTO();
            admin.setEmail(correoAdmin);
            admin.setNombre("admin");
            admin.setApellido("");
            admin.setRolId(1L);
            empleadoService.crearEmpleado(admin);
            System.out.println("Usuario admin creado por defecto");
        }
    }
}

