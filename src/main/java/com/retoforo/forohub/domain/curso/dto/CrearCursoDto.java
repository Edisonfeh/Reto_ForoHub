package com.retoforo.forohub.domain.curso.dto;

import com.retoforo.forohub.domain.curso.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearCursoDto(
        @NotBlank String name,
        @NotNull Categoria categoria) {
}
