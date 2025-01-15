package com.githubmoore.challenge_foro_hub.repository;

import com.githubmoore.challenge_foro_hub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Integer> {
    List<Topico> findByCurso_Id(Integer cursoId);

    List<Topico> findByAutor_Id(Integer autorId);

    List<Topico> findByStatus(Topico.Status status);
}

