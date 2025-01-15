package com.githubmoore.challenge_foro_hub.service;

import com.githubmoore.challenge_foro_hub.model.Curso;
import com.githubmoore.challenge_foro_hub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> getCursoById(int id) {
        return cursoRepository.findById(id);
    }

    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(int id, Curso updatedCurso) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNombre(updatedCurso.getNombre());
            curso.setCategoria(updatedCurso.getCategoria());
            return cursoRepository.save(curso);
        }).orElseThrow(() -> new RuntimeException("Curso no encontrado."));
    }

    public void deleteCurso(int id) {
        cursoRepository.deleteById(id);
    }
}

