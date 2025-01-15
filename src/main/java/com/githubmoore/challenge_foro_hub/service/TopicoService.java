package com.githubmoore.challenge_foro_hub.service;

import com.githubmoore.challenge_foro_hub.model.Topico;
import com.githubmoore.challenge_foro_hub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> getAllTopicos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> getTopicoById(int id) {
        return topicoRepository.findById(id);
    }

    public Topico createTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public Topico updateTopico(int id, Topico updatedTopico) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(updatedTopico.getTitulo());
            topico.setMensaje(updatedTopico.getMensaje());
            topico.setCurso(updatedTopico.getCurso());
            topico.setAutor(updatedTopico.getAutor());
            topico.setStatus(updatedTopico.getStatus());
            return topicoRepository.save(topico);
        }).orElseThrow(() -> new RuntimeException("Tópico no encontrado."));
    }

    public void deleteTopico(int id) {
        topicoRepository.deleteById(id);
    }
}