package com.upiiz.ejercicio_08.proveedores.dto;

import org.springframework.hateoas.RepresentationModel;

public class ProveedorDto extends RepresentationModel<ProveedorDto> {

    //extends RepresentationModel<EntrenadorDto>
    private Long id;
    private String nombreEmpresa;
    private String contacto;
    private String telefono;
    private String correo;
    private String pais;

    public ProveedorDto(Long id, String nombreEmpresa, String contacto, String telefono, String correo, String pais) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.contacto = contacto;
        this.telefono = telefono;
        this.correo = correo;
        this.pais = pais;
    }

    public ProveedorDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
