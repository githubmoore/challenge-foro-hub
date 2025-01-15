package com.githubmoore.challenge_foro_hub.controller;

import com.githubmoore.challenge_foro_hub.dto.CursoDTO;
import com.githubmoore.challenge_foro_hub.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> getAllCursos() {
        List<CursoDTO> cursos = cursoService.getAllCursos();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> getCursoById(@PathVariable Integer id) {
        CursoDTO curso = cursoService.getCursoById(id);
        return ResponseEntity.ok(curso);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> createCurso(@RequestBody CursoDTO cursoDTO) {
        CursoDTO createdCurso = cursoService.createCurso(cursoDTO);
        return ResponseEntity.status(201).body(createdCurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> updateCurso(@PathVariable Integer id, @RequestBody CursoDTO cursoDTO) {
        CursoDTO updatedCurso = cursoService.updateCurso(id, cursoDTO);
        return ResponseEntity.ok(updatedCurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Integer id) {
        cursoService.deleteCurso(id);
        return ResponseEntity.noContent().build();
    }
}
