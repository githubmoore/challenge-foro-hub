package com.githubmoore.challenge_foro_hub.controller;

import com.githubmoore.challenge_foro_hub.dto.RespuestaDTO;
import com.githubmoore.challenge_foro_hub.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public ResponseEntity<List<RespuestaDTO>> getAllRespuestas() {
        List<RespuestaDTO> respuestas = respuestaService.getAllRespuestas();
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaDTO> getRespuestaById(@PathVariable Integer id) {
        RespuestaDTO respuesta = respuestaService.getRespuestaById(id);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<RespuestaDTO> createRespuesta(@RequestBody RespuestaDTO respuestaDTO) {
        RespuestaDTO createdRespuesta = respuestaService.createRespuesta(respuestaDTO);
        return ResponseEntity.status(201).body(createdRespuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaDTO> updateRespuesta(@PathVariable Integer id, @RequestBody RespuestaDTO respuestaDTO) {
        RespuestaDTO updatedRespuesta = respuestaService.updateRespuesta(id, respuestaDTO);
        return ResponseEntity.ok(updatedRespuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRespuesta(@PathVariable Integer id) {
        respuestaService.deleteRespuesta(id);
        return ResponseEntity.noContent().build();
    }
}
