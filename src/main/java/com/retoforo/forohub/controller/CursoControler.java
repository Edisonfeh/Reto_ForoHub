package com.retoforo.forohub.controller;

import com.retoforo.forohub.domain.curso.Curso;
import com.retoforo.forohub.domain.curso.dto.ActualizarCursoDto;
import com.retoforo.forohub.domain.curso.dto.CrearCursoDto;
import com.retoforo.forohub.domain.curso.dto.DetalleCursoDto;
import com.retoforo.forohub.domain.curso.repository.RepositoryCurso;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController  // Para solicitudes http
@RequestMapping("/Cursos")  //Define la ruta Cursos
@SecurityRequirement(name = "bearer-key")  // Significa que requiere autenticacion
@Tag(name = "Curso", description = "Puede pertenecer a una de las muchas categorías definidas")
public class CursoControler {
    @Autowired
    private RepositoryCurso repository;

    @PostMapping
    @Transactional  // Para que las operaciones de la DB se ejecuten
    @Operation(summary = "Registrar un nuevo curso en la BD.")
    public ResponseEntity<DetalleCursoDto> crearTopico(
            @RequestBody @Valid CrearCursoDto crearCursoDTO,
            UriComponentsBuilder uriBuilder){

        Curso curso = new Curso(crearCursoDTO);
        repository.save(curso);
        var uri = uriBuilder.path("/cursos/{i}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalleCursoDto(curso));

    }
    @GetMapping("/all") // Get para todos
    @Operation(summary = "Lee todos los cursos independientemente de su estado")
    public ResponseEntity<Page<DetalleCursoDto>> listarCursos(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        var pagina = repository.findAll(pageable).map(DetalleCursoDto::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping
    @Operation(summary = "Lista de cursos activos")
    public ResponseEntity<Page<DetalleCursoDto>> listarCursosActivos(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        var pagina = repository.findAllByActivoTrue(pageable).map(DetalleCursoDto::new);
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")  // Buscar curdso por ID
    @Operation(summary = "Lee un solo curso por su ID")
    public ResponseEntity<DetalleCursoDto> ListarUnCurso(@PathVariable Long id){
        Curso curso = repository.getReferenceById(id);
        var datosDelCurso = new DetalleCursoDto(
                curso.getId(),
                curso.getName(),
                curso.getCategoria(),
                curso.getActivo()
        );
        return ResponseEntity.ok(datosDelCurso);
    }

    //Actualizacion

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Actualiza el nombre, la categoría o el estado de un curso")
    public ResponseEntity<DetalleCursoDto> actualizarCurso(@RequestBody @Valid ActualizarCursoDto actualizarCursoDTO, @PathVariable Long id){

        Curso curso = repository.getReferenceById(id);

        curso.actualizarCurso(actualizarCursoDTO);

        var datosDelCurso = new DetalleCursoDto(
                curso.getId(),
                curso.getName(),
                curso.getCategoria(),
                curso.getActivo()
        );
        return ResponseEntity.ok(datosDelCurso);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Elimina un curso")
    public ResponseEntity<?> eliminarCurso(@PathVariable Long id){
        Curso curso = repository.getReferenceById(id);
        curso.eliminarCurso();
        return ResponseEntity.noContent().build();
    }
}
