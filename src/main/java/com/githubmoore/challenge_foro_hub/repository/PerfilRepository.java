package com.githubmoore.challenge_foro_hub.repository;

import com.githubmoore.challenge_foro_hub.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
}
