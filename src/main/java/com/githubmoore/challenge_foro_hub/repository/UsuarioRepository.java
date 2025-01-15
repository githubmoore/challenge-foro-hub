package com.githubmoore.challenge_foro_hub.repository;

import com.githubmoore.challenge_foro_hub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreoElectronico(String correoElectronico);
}
