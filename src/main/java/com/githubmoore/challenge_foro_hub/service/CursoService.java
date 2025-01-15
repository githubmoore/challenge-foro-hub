package com.githubmoore.challenge_foro_hub.service;

import com.githubmoore.challenge_foro_hub.dto.CursoDTO;
import com.githubmoore.challenge_foro_hub.model.Curso;
import com.githubmoore.challenge_foro_hub.repository.CursoRepository;
import com.githubmoore.challenge_foro_hub.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDTO> getAllCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CursoDTO getCursoById(Long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Curso not found with id " + id));
        return mapToDTO(curso);
    }

    public CursoDTO createCurso(CursoDTO cursoDTO) {
        Curso curso = mapToEntity(cursoDTO);
        Curso savedCurso = cursoRepository.save(curso);
        return mapToDTO(savedCurso);
    }

    public CursoDTO updateCurso(Long id, CursoDTO cursoDTO) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Curso not found with id " + id));
        curso.setNombre(cursoDTO.getNombre());
        curso.setDescripcion(cursoDTO.getDescripcion());
        Curso updatedCurso = cursoRepository.save(curso);
        return mapToDTO(updatedCurso);
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    private CursoDTO mapToDTO(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId().longValue()); // Convertir Integer a Long
        cursoDTO.setNombre(curso.getNombre());
        cursoDTO.setDescripcion(curso.getDescripcion());
        return cursoDTO;
    }

    private Curso mapToEntity(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setId(cursoDTO.getId().intValue()); // Convertir Long a Integer
        curso.setNombre(cursoDTO.getNombre());
        curso.setDescripcion(cursoDTO.getDescripcion());
        return curso;
    }
}
