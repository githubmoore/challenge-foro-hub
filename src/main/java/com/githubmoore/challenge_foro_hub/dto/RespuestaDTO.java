package com.githubmoore.challenge_foro_hub.dto;

import java.time.LocalDateTime;

public class RespuestaDTO {
    private Integer id;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Integer topicoId;
    private Long autorId;

    // Constructores
    public RespuestaDTO() {}

    public RespuestaDTO(Integer id, String mensaje, LocalDateTime fechaCreacion, Integer topicoId, Long autorId) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.topicoId = topicoId;
        this.autorId = autorId;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(Integer topicoId) {
        this.topicoId = topicoId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Object toEntity() {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    public void setSolucion(Boolean solucion) {
        this.setSolucion(solucion);
    }

    public Boolean getSolucion() {
        return getSolucion();
    }

}
