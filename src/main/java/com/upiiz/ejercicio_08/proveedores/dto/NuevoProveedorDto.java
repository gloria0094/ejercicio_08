package com.upiiz.ejercicio_08.proveedores.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class NuevoProveedorDto {
    @Schema(description = "Nombre completo del proveedor", example ="José Díaz Jaramillo")
    private String nombreEmpresa;
    @Schema(description = "Nombre de la persona de contacto", example="Francisco Flores")
    private String contacto;
    @Schema(description = "Número telefónico de contacto", example = "4922345678")
    private String telefono;
    @Schema(description = "Correo electrónico", example = "ejemplo@gmail.com")
    private String correo;
    @Schema(description = "País de origen del proveedor", example = "México")
    private String pais;

    public NuevoProveedorDto( String nombreEmpresa, String contacto, String telefono, String correo, String pais) {
        this.nombreEmpresa = nombreEmpresa;
        this.contacto = contacto;
        this.telefono = telefono;
        this.correo = correo;
        this.pais = pais;
    }


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
