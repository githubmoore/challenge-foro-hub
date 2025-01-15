package com.githubmoore.challenge_foro_hub.dto;

import java.time.LocalDateTime;

public class RespuestaDTO {
    private Long id;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Long topicoId;
    private Long autorId;

    // Constructores
    public RespuestaDTO() {}

    public RespuestaDTO(Long id, String mensaje, LocalDateTime fechaCreacion, Long topicoId, Long autorId) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.topicoId = topicoId;
        this.autorId = autorId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(Long topicoId) {
        this.topicoId = topicoId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
}
