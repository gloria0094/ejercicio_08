package com.upiiz.ejercicio_08.proveedores;


import com.upiiz.ejercicio_08.proveedores.dto.CustomResponse;
import com.upiiz.ejercicio_08.proveedores.dto.NuevoProveedorDto;
import com.upiiz.ejercicio_08.proveedores.dto.ProveedorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
@CrossOrigin(origins = "*")
@Tag(name = "Proveedores", description = "Operaciones CRUD para la gestión de proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @Operation(summary = "Obtener todos los proveedores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recurso encontrado"),
            @ApiResponse(responseCode = "400", description = "Parámetro inválido", content = @Content),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno", content = @Content)
    })
    @GetMapping
    public ResponseEntity<CustomResponse<List<ProveedorDto>>> listarTodos() {
        List<ProveedorDto> proveedores = proveedorService.findAll();
        CustomResponse<List<ProveedorDto>> response = new CustomResponse<>(
                "200 OK", "Recurso encontrado", proveedores
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtener un proveedor por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recurso encontrado"),
            @ApiResponse(responseCode = "400", description = "Parámetro inválido", content = @Content),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<ProveedorDto>> obtenerPorId(@PathVariable Long id) {
        try {
            ProveedorDto proveedor = proveedorService.findById(id);
            if (proveedor != null) {
                CustomResponse<ProveedorDto> response = new CustomResponse<>(
                        "200 OK", "Recurso encontrado", proveedor
                );
                return ResponseEntity.ok(response);
            } else {
                CustomResponse<ProveedorDto> response = new CustomResponse<>(
                        "404 NOT_FOUND", "No encontrado", null
                );
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            CustomResponse<ProveedorDto> response = new CustomResponse<>(
                    "400 BAD_REQUEST", "Parámetro inválido o error", null
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @Operation(summary = "Crear un nuevo proveedor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Recurso creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o incompletos", content = @Content),
            @ApiResponse(responseCode = "409", description = "Conflicto (duplicado)", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
    })
    @PostMapping
    public ResponseEntity<CustomResponse<ProveedorDto>> crear(@RequestBody NuevoProveedorDto nuevoProveedorDto) {
        try {
            ProveedorDto creado = proveedorService.save(nuevoProveedorDto);
            CustomResponse<ProveedorDto> response = new CustomResponse<>(
                    "201 CREATED", "Recurso creado correctamente", creado
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            // Maneja el conflicto de correo duplicado u otros errores de negocio
            CustomResponse<ProveedorDto> response = new CustomResponse<>(
                    "409 CONFLICT", e.getMessage(), null
            );
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }

    @Operation(summary = "Actualizar un proveedor existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recurso actualizado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
            @ApiResponse(responseCode = "409", description = "Conflicto (duplicado)", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<ProveedorDto>> actualizar(@PathVariable Long id, @RequestBody NuevoProveedorDto nuevoProveedorDto) {
        ProveedorDto actualizado = proveedorService.update(id, nuevoProveedorDto);
        if (actualizado != null) {
            CustomResponse<ProveedorDto> response = new CustomResponse<>(
                    "200 OK", "Recurso actualizado", actualizado
            );
            return ResponseEntity.ok(response);
        } else {
            CustomResponse<ProveedorDto> response = new CustomResponse<>(
                    "404 NOT_FOUND", "No encontrado", null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Operation(summary = "Eliminar un proveedor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eliminación exitosa"),
            @ApiResponse(responseCode = "204", description = "Eliminación exitosa (Sin contenido)", content = @Content),
            @ApiResponse(responseCode = "400", description = "Parámetro inválido", content = @Content),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error del servidor", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<Void>> eliminar(@PathVariable Long id) {
        try {
            proveedorService.delete(id);
            CustomResponse<Void> response = new CustomResponse<>(
                    "200 OK", "Eliminación exitosa", null
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            CustomResponse<Void> response = new CustomResponse<>(
                    "404 NOT_FOUND", "No encontrado", null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
