package com.githubmoore.challenge_foro_hub.service;

import com.githubmoore.challenge_foro_hub.dto.UsuarioDTO;
import com.githubmoore.challenge_foro_hub.model.Usuario;
import com.githubmoore.challenge_foro_hub.repository.UsuarioRepository;
import com.githubmoore.challenge_foro_hub.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public UsuarioDTO getUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario not found with id " + id));
        return mapToDTO(usuario);
    }

    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapToEntity(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return mapToDTO(savedUsuario);
    }

    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario not found with id " + id));
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());
        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return mapToDTO(updatedUsuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO mapToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setPerfil(usuario.getPerfil().name()); // Asumiendo que Perfil es un enum
        return usuarioDTO;
    }

    private Usuario mapToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword()); // Asegúrate de manejar las contraseñas de manera segura
        usuario.setPerfil(usuario.getPerfil()); // Asumiendo que Perfil es un enum
        return usuario;
    }
}
