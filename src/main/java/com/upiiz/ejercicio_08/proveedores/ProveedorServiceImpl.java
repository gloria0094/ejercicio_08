package com.upiiz.ejercicio_08.proveedores;

import com.upiiz.ejercicio_08.proveedores.dto.NuevoProveedorDto;
import com.upiiz.ejercicio_08.proveedores.dto.ProveedorDto;
import com.upiiz.ejercicio_08.proveedores.entities.ProveedorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements ProveedorService{
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public ProveedorDto save(NuevoProveedorDto nuevoProveedorDto) {
        // Regla de negocio: Validar que el correo no esté duplicado (ignorando mayúsculas/minúsculas)
        proveedorRepository.findByCorreoIgnoreCase(nuevoProveedorDto.getCorreo()).ifPresent(e -> {
            throw new IllegalArgumentException("El correo ya existe en el sistema");
        });

        ProveedorEntity nuevoProveedor = new ProveedorEntity(
                nuevoProveedorDto.getNombreEmpresa(),
                nuevoProveedorDto.getContacto(),
                nuevoProveedorDto.getTelefono(),
                nuevoProveedorDto.getCorreo(),
                nuevoProveedorDto.getPais()
        );

        ProveedorEntity proveedorGuardado = proveedorRepository.save(nuevoProveedor);

        return new ProveedorDto(
                proveedorGuardado.getId(),
                proveedorGuardado.getNombreEmpresa(),
                proveedorGuardado.getContacto(),
                proveedorGuardado.getTelefono(),
                proveedorGuardado.getCorreo(),
                proveedorGuardado.getPais()
        );
    }

    @Override
    public List<ProveedorDto> findAll() {
        List<ProveedorEntity> entidades = proveedorRepository.findAll();
        // Convertir lista de Entidades a lista de DTOs
        return entidades.stream().map(e -> new ProveedorDto(
                e.getId(),
                e.getNombreEmpresa(),
                e.getContacto(),
                e.getTelefono(),
                e.getCorreo(),
                e.getPais()
        )).collect(Collectors.toList());
    }

    @Override
    public ProveedorDto findById(Long id) {
        Optional<ProveedorEntity> proveedorOpt = proveedorRepository.findById(id);
        if (proveedorOpt.isPresent()) {
            ProveedorEntity e = proveedorOpt.get();
            return new ProveedorDto(
                    e.getId(),
                    e.getNombreEmpresa(),
                    e.getContacto(),
                    e.getTelefono(),
                    e.getCorreo(),
                    e.getPais()
            );
        }
        return null;
    }

    @Override
    public ProveedorDto update(Long id, NuevoProveedorDto updateProveedorDto) {
        Optional<ProveedorEntity> proveedorOpt = proveedorRepository.findById(id);
        if (proveedorOpt.isPresent()) {
            ProveedorEntity proveedor = proveedorOpt.get();
            proveedor.setNombreEmpresa(updateProveedorDto.getNombreEmpresa());
            proveedor.setContacto(updateProveedorDto.getContacto());
            proveedor.setTelefono(updateProveedorDto.getTelefono());
            proveedor.setCorreo(updateProveedorDto.getCorreo());
            proveedor.setPais(updateProveedorDto.getPais());

            ProveedorEntity actualizado = proveedorRepository.save(proveedor);
            return new ProveedorDto(
                    actualizado.getId(),
                    actualizado.getNombreEmpresa(),
                    actualizado.getContacto(),
                    actualizado.getTelefono(),
                    actualizado.getCorreo(),
                    actualizado.getPais()
            );
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (proveedorRepository.existsById(id)) {
            proveedorRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El proveedor con ID " + id + " no existe");
        }
    }
}
