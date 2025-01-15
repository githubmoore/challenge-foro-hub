package com.githubmoore.challenge_foro_hub.dto;

public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private String perfil;

    // Constructores
    public UsuarioDTO() {}

    public UsuarioDTO(Long id, String nombre, String email, String perfil) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.perfil = perfil;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}