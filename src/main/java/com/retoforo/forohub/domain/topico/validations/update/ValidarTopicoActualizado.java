package com.retoforo.forohub.domain.topico.validations.update;

import com.retoforo.forohub.domain.topico.dto.ActualizarTopicoDTO;
import org.springframework.stereotype.Component;


public interface ValidarTopicoActualizado
{
    void validate(ActualizarTopicoDTO data);
}
