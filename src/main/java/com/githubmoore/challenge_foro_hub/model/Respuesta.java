package com.githubmoore.challenge_foro_hub.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Respuesta")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(nullable = false)
    private Boolean solucion = false;

    @ManyToOne
    @JoinColumn(name = "topico", nullable = false)
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "autor", nullable = false)
    private Usuario autor;

    // Getters and Setters
}

