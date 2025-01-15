package com.githubmoore.challenge_foro_hub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    // Getters and Setters
}
