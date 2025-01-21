package com.retoforo.forohub.domain.respuesta.validations.update;

import com.retoforo.forohub.domain.respuesta.dto.ActualizarRespuestaDto;

public interface ValidarRespuestaActualizada {

    void validate(ActualizarRespuestaDto data, Long respuestaId);
}
