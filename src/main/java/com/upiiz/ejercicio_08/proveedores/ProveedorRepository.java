package com.upiiz.ejercicio_08.proveedores;

import com.upiiz.ejercicio_08.proveedores.entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {
    Optional<ProveedorEntity> findByCorreoIgnoreCase(String correo);
}
