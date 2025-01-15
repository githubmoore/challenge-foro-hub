package com.githubmoore.challenge_foro_hub.service;

import com.githubmoore.challenge_foro_hub.model.Respuesta;
import com.githubmoore.challenge_foro_hub.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    public List<Respuesta> getAllRespuestas() {
        return respuestaRepository.findAll();
    }

    public Optional<Respuesta> getRespuestaById(int id) {
        return respuestaRepository.findById(id);
    }

    public Respuesta createRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public Respuesta updateRespuesta(int id, Respuesta updatedRespuesta) {
        return respuestaRepository.findById(id).map(respuesta -> {
            respuesta.setMensaje(updatedRespuesta.getMensaje());
            respuesta.setAutor(updatedRespuesta.getAutor());
            respuesta.setTopico(updatedRespuesta.getTopico());
            respuesta.setSolucion(updatedRespuesta.isSolucion());
            return respuestaRepository.save(respuesta);
        }).orElseThrow(() -> new RuntimeException("Respuesta no encontrada."));
    }

    public void deleteRespuesta(int id) {
        respuestaRepository.deleteById(id);
    }
}
