package com.upiiz.ejercicio_08.proveedores.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedores")
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreEmpresa;
    private String contacto;
    private String telefono;
    private String correo;
    private String pais;

    public ProveedorEntity(String pais, String correo, String telefono, String contacto, String nombreEmpresa, Long id) {
        this.pais = pais;
        this.correo = correo;
        this.telefono = telefono;
        this.contacto = contacto;
        this.nombreEmpresa = nombreEmpresa;
        this.id = id;
    }

    public ProveedorEntity() {
    }

    public ProveedorEntity(String nombreEmpresa, String contacto, String telefono, String correo, String pais) {
        this.nombreEmpresa = nombreEmpresa;
        this.contacto = contacto;
        this.telefono = telefono;
        this.correo = correo;
        this.pais = pais;
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
