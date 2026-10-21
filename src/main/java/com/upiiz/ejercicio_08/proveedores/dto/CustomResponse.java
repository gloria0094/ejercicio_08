package com.upiiz.ejercicio_08.proveedores.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class CustomResponse<T> {
    @Schema(description = "Estado numérico o de texto de la respuesta", example = "200 OK")
    private String estado;

    @Schema(description = "Mensaje descriptivo del resultado", example = "Recurso encontrado")
    private String mensaje;

    @Schema(description = "Datos o valores resultantes de la operación")
    private T datos;

    public CustomResponse() {
    }

    public CustomResponse(String estado, String mensaje, T datos) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.datos = datos;
    }

    public CustomResponse(String estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public T getDatos() {
        return datos;
    }

    public void setDatos(T datos) {
        this.datos = datos;
    }
}
