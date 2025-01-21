package com.retoforo.forohub.domain.topico.dto;

import com.retoforo.forohub.domain.curso.Categoria;
import com.retoforo.forohub.domain.topico.Estado;
import com.retoforo.forohub.domain.topico.Topico;

import java.time.LocalDateTime;

public record   DetalleTopicoDTO (Long id,
                                  String titulo,
                                  String mensaje,
                                  LocalDateTime fechaCreacion,
                                  LocalDateTime ultimaActualizacion,
                                  Estado estado,
                                  String usuario,
                                  String curso,
                                  Categoria categoriaCurso)
{

    public DetalleTopicoDTO (Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getUltimaActualizacion(),
                topico.getEstado(),
                topico.getUsuario().getUsername(),
                topico.getCurso().getName(),
                topico.getCurso().getCategoria()
        );
    }

}


