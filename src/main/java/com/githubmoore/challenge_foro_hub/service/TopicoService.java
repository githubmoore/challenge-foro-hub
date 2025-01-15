package com.githubmoore.challenge_foro_hub.service;

import com.githubmoore.challenge_foro_hub.dto.TopicoDTO;
import com.githubmoore.challenge_foro_hub.model.Topico;
import com.githubmoore.challenge_foro_hub.repository.TopicoRepository;
import com.githubmoore.challenge_foro_hub.repository.CursoRepository;
import com.githubmoore.challenge_foro_hub.repository.UsuarioRepository;
import com.githubmoore.challenge_foro_hub.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<TopicoDTO> getAllTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return topicos.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public TopicoDTO getTopicoById(Integer id) {
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topico not found with id " + id));
        return mapToDTO(topico);
    }

    public TopicoDTO createTopico(TopicoDTO topicoDTO) {
        Topico topico = mapToEntity(topicoDTO);
        Topico savedTopico = topicoRepository.save(topico);
        return mapToDTO(savedTopico);
    }

    public TopicoDTO updateTopico(Integer id, TopicoDTO topicoDTO) {
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topico not found with id " + id));
        topico.setTitulo(topicoDTO.getTitulo());
        topico.setMensaje(topicoDTO.getMensaje());
        topico.setFechaCreacion(topicoDTO.getFechaCreacion());
        topico.setStatus(Topico.Status.valueOf(topicoDTO.getEstado()));
        topico.setCurso(cursoRepository.findById(topicoDTO.getCursoId().intValue()).orElseThrow(() -> new ResourceNotFoundException("Curso not found with id " + topicoDTO.getCursoId())));
        topico.setAutor(usuarioRepository.getById(topicoDTO.getAutorId().intValue()).orElseThrow(() -> new ResourceNotFoundException("Usuario not found with id " + topicoDTO.getAutorId())));
        Topico updatedTopico = topicoRepository.save(topico);
        return mapToDTO(updatedTopico);
    }

    public void deleteTopico(Integer id) {
        topicoRepository.deleteById(id);
    }

    private TopicoDTO mapToDTO(Topico topico) {
        TopicoDTO topicoDTO = new TopicoDTO();
        topicoDTO.setId(topico.getId().longValue()); // Convertir Integer a Long
        topicoDTO.setTitulo(topico.getTitulo());
        topicoDTO.setMensaje(topico.getMensaje());
        topicoDTO.setFechaCreacion(topico.getFechaCreacion());
        topicoDTO.setEstado(topico.getStatus().name());
        topicoDTO.setCursoId(topico.getCurso().getId().longValue()); // Convertir Integer a Long
        topicoDTO.setAutorId(topico.getAutor().getId().longValue()); // Convertir Integer a Long
        return topicoDTO;
    }

    private Topico mapToEntity(TopicoDTO topicoDTO) {
        Topico topico = new Topico();
        topico.setId(topicoDTO.getId().intValue()); // Convertir Long a Integer
        topico.setTitulo(topicoDTO.getTitulo());
        topico.setMensaje(topicoDTO.getMensaje());
        topico.setFechaCreacion(topicoDTO.getFechaCreacion());
        topico.setStatus(Topico.Status.valueOf(topicoDTO.getEstado()));
        topico.setCurso(cursoRepository.findById(topicoDTO.getCursoId().intValue()).orElseThrow(() -> new ResourceNotFoundException("Curso not found with id " + topicoDTO.getCursoId())));
        topico.setAutor(usuarioRepository.getById(topicoDTO.getAutorId().intValue()).orElseThrow(() -> new ResourceNotFoundException("Usuario not found with id " + topicoDTO.getAutorId())));
        return topico;
    }
}
