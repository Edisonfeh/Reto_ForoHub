package com.retoforo.forohub.domain.curso.dto;

import com.retoforo.forohub.domain.curso.Categoria;

public record ActualizarCursoDto(
        String name,
        Categoria categoria,
        Boolean activo) {
}