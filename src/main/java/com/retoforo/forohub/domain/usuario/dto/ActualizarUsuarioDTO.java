package com.retoforo.forohub.domain.usuario.dto;

import com.retoforo.forohub.domain.usuario.Role;

public record ActualizarUsuarioDTO(
        String password,
        Role role,
        String nombre,
        String apellido,
        String email,
        Boolean enabled) {
}
