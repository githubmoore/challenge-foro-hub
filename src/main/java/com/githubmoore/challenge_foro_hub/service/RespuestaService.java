package com.githubmoore.challenge_foro_hub.service;

import com.githubmoore.challenge_foro_hub.dto.RespuestaDTO;
import com.githubmoore.challenge_foro_hub.model.Respuesta;
import com.githubmoore.challenge_foro_hub.repository.RespuestaRepository;
import com.githubmoore.challenge_foro_hub.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    public List<RespuestaDTO> getAllRespuestas() {
        List<Respuesta> respuestas = respuestaRepository.findAll();
        return respuestas.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public RespuestaDTO getRespuestaById(Integer id) {
        Respuesta respuesta = respuestaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Respuesta not found with id " + id));
        return mapToDTO(respuesta);
    }

    public RespuestaDTO createRespuesta(RespuestaDTO respuestaDTO) {
        Respuesta respuesta = mapToEntity(respuestaDTO);
        Respuesta savedRespuesta = respuestaRepository.save(respuesta);
        return mapToDTO(savedRespuesta);
    }

    public RespuestaDTO updateRespuesta(Integer id, RespuestaDTO respuestaDTO, Boolean solucion) {
        return respuestaRepository.findById(id).map(respuesta -> {
            respuesta.setMensaje(respuestaDTO.getMensaje());
            respuesta.setFechaCreacion(respuestaDTO.getFechaCreacion());
            Respuesta updatedRespuesta = respuestaRepository.save(respuesta);
            return mapToDTO(updatedRespuesta);
        }).orElseThrow(() -> new ResourceNotFoundException("Respuesta not found with id " + id));
    }

    public void deleteRespuesta(Integer id) {
        respuestaRepository.deleteById(id);
    }

    private RespuestaDTO mapToDTO(Respuesta respuesta) {
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        respuestaDTO.setId(respuesta.getId().longValue()); // Convertir Integer a Long
        respuestaDTO.setMensaje(respuesta.getMensaje());
        respuestaDTO.setFechaCreacion(respuesta.getFechaCreacion());
        respuestaDTO.setTopicoId(respuesta.getTopico().getId().longValue()); // Convertir Integer a Long
        respuestaDTO.setAutorId(respuesta.getAutor().getId().longValue()); // Convertir Integer a Long
        return respuestaDTO;
    }

    private Respuesta mapToEntity(RespuestaDTO respuestaDTO) {
        Respuesta respuesta = new Respuesta();
        respuesta.setId(respuestaDTO.getId().intValue()); // Convertir Long a Integer
        respuesta.setMensaje(respuestaDTO.getMensaje());
        respuesta.setFechaCreacion(respuestaDTO.getFechaCreacion());
        

        return respuesta;
    }

    public RespuestaDTO updateRespuesta(Integer id, RespuestaDTO respuestaDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRespuesta'");
    }
}
