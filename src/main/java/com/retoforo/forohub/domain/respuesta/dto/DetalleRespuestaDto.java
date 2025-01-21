package com.retoforo.forohub.domain.respuesta.dto;

import com.retoforo.forohub.domain.respuesta.Respuesta;

import java.time.LocalDateTime;

public record DetalleRespuestaDto(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        LocalDateTime ultimaActualizacion,
        Boolean solucion,
        Boolean borrado,
        Long usuarioId,
        String username,
        Long topicoId,
        String topico)
{

    public DetalleRespuestaDto (Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getUltimaActualizacion(),
                respuesta.getSolucion(),
                respuesta.getBorrado(),
                respuesta.getUsuario().getId(),
                respuesta.getUsuario().getUsername(),
                respuesta.getTopico().getId(),
                respuesta.getTopico().getTitulo());

    }
}
