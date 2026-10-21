package com.upiiz.ejercicio_08.proveedores;

import com.upiiz.ejercicio_08.proveedores.dto.NuevoProveedorDto;
import com.upiiz.ejercicio_08.proveedores.dto.ProveedorDto;

import java.util.List;

public interface ProveedorService {
    ProveedorDto save(NuevoProveedorDto nuevoProveedorDto);
    //Muestre todos
    List<ProveedorDto> findAll();
    //Muestra por id
    ProveedorDto findById(Long id);
    //Actualice
    ProveedorDto update(Long id, NuevoProveedorDto updateProveedorDto);
    //Eliminar
    void delete(Long id);
}
