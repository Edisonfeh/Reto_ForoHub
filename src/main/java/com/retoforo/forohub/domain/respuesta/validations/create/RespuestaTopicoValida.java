package com.retoforo.forohub.domain.respuesta.validations.create;

import com.retoforo.forohub.domain.respuesta.dto.CrearRespuestaDto;
import com.retoforo.forohub.domain.topico.Estado;
import com.retoforo.forohub.domain.topico.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaTopicoValida implements ValidarRespuestaCreada {

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validate(CrearRespuestaDto data) {
        var topicoExiste = repository.existsById(data.topicoId());

        if (!topicoExiste) {
            throw new ValidationException("Este topico no existe.");
        }

        var topicoAbierto = repository.findById(data.topicoId()).get().getEstado();

        if (topicoAbierto != Estado.OPEN) {
            throw new ValidationException("Este topico no esta abierto.");

        }
    }
}
