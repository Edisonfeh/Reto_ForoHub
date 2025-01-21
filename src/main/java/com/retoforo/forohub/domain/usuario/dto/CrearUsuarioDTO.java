package com.retoforo.forohub.domain.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CrearUsuarioDTO(@NotBlank String username,
                              @NotBlank String password,
                              @NotBlank String nombre,
                              @NotBlank String apellido,
                              @NotBlank @Email String email) {
    @Override
    public @NotBlank String username() {
        return username;
    }

    @Override
    public @NotBlank String nombre() {
        return nombre;
    }

    @Override
    public @NotBlank String apellido() {
        return apellido;
    }

    @Override
    public @NotBlank @Email String email() {
        return email;
    }
}
