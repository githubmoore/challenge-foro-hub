package com.githubmoore.challenge_foro_hub.service;

import com.githubmoore.challenge_foro_hub.model.Usuario;
import com.githubmoore.challenge_foro_hub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(int id) {
        return usuarioRepository.findById(id);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(int id, Usuario updatedUsuario) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(updatedUsuario.getNombre());
            usuario.setCorreoElectronico(updatedUsuario.getCorreoElectronico());
            usuario.setContrasena(updatedUsuario.getContrasena());
            usuario.setPerfiles(updatedUsuario.getPerfiles());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
    }

    public void deleteUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
}