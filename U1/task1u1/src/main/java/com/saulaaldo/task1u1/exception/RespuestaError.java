package com.saulaaldo.task1u1.exception;

import java.time.LocalDateTime;


public class RespuestaError {
    private LocalDateTime fecha;
    private int estado;
    private String mensaje;

    public RespuestaError(int estado, String mensaje) {
        this.fecha = LocalDateTime.now();
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha() { return fecha; }
    public int getEstado() { return estado; }
    public String getMensaje() { return mensaje; }
}
