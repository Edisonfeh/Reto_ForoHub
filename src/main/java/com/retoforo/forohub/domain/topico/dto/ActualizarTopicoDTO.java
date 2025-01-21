package com.retoforo.forohub.domain.topico.dto;

import com.retoforo.forohub.domain.topico.Estado;

public  record ActualizarTopicoDTO(
        String titulo,
        String mensaje,
        Estado estado,
        Long cursoId){

}
