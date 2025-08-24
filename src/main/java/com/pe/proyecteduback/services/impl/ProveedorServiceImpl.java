package com.pe.proyecteduback.services.impl;

import com.pe.proyecteduback.dtos.ProveedorRequestDTO;
import com.pe.proyecteduback.dtos.ProveedorResponseDTO;
import com.pe.proyecteduback.entities.Proveedor;
import com.pe.proyecteduback.repositories.ProveedorRepository;
import com.pe.proyecteduback.services.ProveedorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public ProveedorResponseDTO crearProveedor(ProveedorRequestDTO request) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(request.getNombre());
        proveedor.setEmail(request.getEmail());
        proveedor.setTelefono(request.getTelefono());

        proveedor = proveedorRepository.save(proveedor);
        return mapToResponse(proveedor);
    }

    @Override
    public ProveedorResponseDTO actualizarProveedor(Long id, ProveedorRequestDTO request) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        proveedor.setNombre(request.getNombre());
        proveedor.setEmail(request.getEmail());
        proveedor.setTelefono(request.getTelefono());

        proveedor = proveedorRepository.save(proveedor);
        return mapToResponse(proveedor);
    }

    @Override
    public void eliminarProveedor(Long id) {
        if (!proveedorRepository.existsById(id)) {
            throw new RuntimeException("Proveedor no encontrado");
        }
        proveedorRepository.deleteById(id);
    }

    @Override
    public ProveedorResponseDTO obtenerProveedorPorId(Long id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        return mapToResponse(proveedor);
    }

    @Override
    public List<ProveedorResponseDTO> listarProveedores() {
        return proveedorRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ProveedorResponseDTO mapToResponse(Proveedor proveedor) {
        return new ProveedorResponseDTO(
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getContacto(),
                proveedor.getTelefono(),
                proveedor.getEmail(),
                proveedor.getDireccion(),
                proveedor.getCreatedAt(),
                proveedor.getUpdatedAt()
        );
    }
}
