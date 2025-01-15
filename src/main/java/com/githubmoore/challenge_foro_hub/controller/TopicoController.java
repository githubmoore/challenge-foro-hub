package com.githubmoore.challenge_foro_hub.controller;

import com.githubmoore.challenge_foro_hub.dto.TopicoDTO;
import com.githubmoore.challenge_foro_hub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public ResponseEntity<List<TopicoDTO>> getAllTopicos() {
        List<TopicoDTO> topicos = topicoService.getAllTopicos();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDTO> getTopicoById(@PathVariable Long id) {
        TopicoDTO topico = topicoService.getTopicoById(id);
        return ResponseEntity.ok(topico);
    }

    @PostMapping
    public ResponseEntity<TopicoDTO> createTopico(@RequestBody TopicoDTO topicoDTO) {
        TopicoDTO createdTopico = topicoService.createTopico(topicoDTO);
        return ResponseEntity.status(201).body(createdTopico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDTO> updateTopico(@PathVariable Long id, @RequestBody TopicoDTO topicoDTO) {
        TopicoDTO updatedTopico = topicoService.updateTopico(id, topicoDTO);
        return ResponseEntity.ok(updatedTopico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopico(@PathVariable Long id) {
        topicoService.deleteTopico(id);
        return ResponseEntity.noContent().build();
    }
}
