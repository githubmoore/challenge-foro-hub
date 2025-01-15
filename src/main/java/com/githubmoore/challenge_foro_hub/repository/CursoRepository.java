package com.githubmoore.challenge_foro_hub.repository;

import com.githubmoore.challenge_foro_hub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
