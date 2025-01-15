package com.githubmoore.challenge_foro_hub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class TopicoDTO {
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String titulo;

    @NotBlank
    @Size(max = 1000)
    private String mensaje;

    private LocalDateTime fechaCreacion;

    @NotBlank
    @Size(max = 50)
    private String estado;

    private Long cursoId;
    private Long autorId;

    // Constructores
    public TopicoDTO() {}

    public TopicoDTO(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String estado, Long cursoId, Long autorId) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.cursoId = cursoId;
        this.autorId = autorId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    @Override
    public String toString() {
        return "TopicoDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estado='" + estado + '\'' +
                ", cursoId=" + cursoId +
                ", autorId=" + autorId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopicoDTO topicoDTO = (TopicoDTO) o;

        if (id != null ? !id.equals(topicoDTO.id) : topicoDTO.id != null) return false;
        if (titulo != null ? !titulo.equals(topicoDTO.titulo) : topicoDTO.titulo != null) return false;
        if (mensaje != null ? !mensaje.equals(topicoDTO.mensaje) : topicoDTO.mensaje != null) return false;
        if (fechaCreacion != null ? !fechaCreacion.equals(topicoDTO.fechaCreacion) : topicoDTO.fechaCreacion != null) return false;
        if (estado != null ? !estado.equals(topicoDTO.estado) : topicoDTO.estado != null) return false;
        if (cursoId != null ? !cursoId.equals(topicoDTO.cursoId) : topicoDTO.cursoId != null) return false;
        return autorId != null ? autorId.equals(topicoDTO.autorId) : topicoDTO.autorId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (mensaje != null ? mensaje.hashCode() : 0);
        result = 31 * result + (fechaCreacion != null ? fechaCreacion.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (cursoId != null ? cursoId.hashCode() : 0);
        result = 31 * result + (autorId != null ? autorId.hashCode() : 0);
        return result;
    }
}
