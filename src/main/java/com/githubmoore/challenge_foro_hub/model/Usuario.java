package com.githubmoore.challenge_foro_hub.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String correoElectronico;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private Integer perfiles;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Topico> topicos;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas;

    // Getters and Setters
}

