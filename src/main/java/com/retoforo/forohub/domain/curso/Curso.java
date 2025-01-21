package com.retoforo.forohub.domain.curso;

import com.retoforo.forohub.domain.curso.dto.ActualizarCursoDto;
import com.retoforo.forohub.domain.curso.dto.CrearCursoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cursos")
@Entity(name = "Curso")
@EqualsAndHashCode(of = "id")

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean activo;

    public Curso(CrearCursoDto crearCursoDto) {
        this.name = crearCursoDto.name();
        this.categoria = crearCursoDto.categoria();
        this.activo = true; //Automaticamente el curso estara activo.
    }

    public void actualizarCurso(ActualizarCursoDto actualizarCursoDTO) {

        if (actualizarCursoDTO.name() != null) {
            this.name = actualizarCursoDTO.name();
        }
        if (actualizarCursoDTO.categoria() != null) {
            this.categoria = actualizarCursoDTO.categoria();
        }
        if (actualizarCursoDTO.activo() != null) {
            this.activo = actualizarCursoDTO.activo();
        }

    }

    public void eliminarCurso () {
        this.activo = false;
    }
}