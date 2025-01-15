package com.githubmoore.challenge_foro_hub.repository;

import com.githubmoore.challenge_foro_hub.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {
    List<Respuesta> findByTopico_Id(Integer topicoId);

    List<Respuesta> findByAutor_Id(Integer autorId);
}
