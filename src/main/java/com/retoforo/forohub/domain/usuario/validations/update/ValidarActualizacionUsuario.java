package com.retoforo.forohub.domain.usuario.validations.update;

import com.retoforo.forohub.domain.usuario.dto.ActualizarUsuarioDTO;

public interface ValidarActualizacionUsuario {
    void validate(ActualizarUsuarioDTO data);
}
