package com.githubmoore.challenge_foro_hub.service;

import com.githubmoore.challenge_foro_hub.model.Perfil;
import com.githubmoore.challenge_foro_hub.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> getAllPerfiles() {
        return perfilRepository.findAll();
    }

    public Optional<Perfil> getPerfilById(int id) {
        return perfilRepository.findById(id);
    }

    public Perfil createPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public Perfil updatePerfil(int id, Perfil updatedPerfil) {
        return perfilRepository.findById(id).map(perfil -> {
            perfil.setNombre(updatedPerfil.getNombre());
            return perfilRepository.save(perfil);
        }).orElseThrow(() -> new RuntimeException("Perfil no encontrado."));
    }

    public void deletePerfil(int id) {
        perfilRepository.deleteById(id);
    }
}

