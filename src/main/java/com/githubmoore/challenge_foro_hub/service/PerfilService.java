package com.githubmoore.challenge_foro_hub.service;

import com.githubmoore.challenge_foro_hub.model.Perfil;
import com.githubmoore.challenge_foro_hub.repository.PerfilRepository;
import com.githubmoore.challenge_foro_hub.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> getAllPerfiles() {
        return perfilRepository.findAll();
    }

    public Perfil getPerfilById(Long id) {
        return perfilRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Perfil not found with id " + id));
    }

    public Perfil createPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public Perfil updatePerfil(Long id, Perfil updatedPerfil) {
        return perfilRepository.findById(id).map(perfil -> {
            perfil.setNombre(updatedPerfil.getNombre());
            return perfilRepository.save(perfil);
        }).orElseThrow(() -> new ResourceNotFoundException("Perfil not found with id " + id));
    }

    public void deletePerfil(Long id) {
        perfilRepository.deleteById(id);
    }
}
