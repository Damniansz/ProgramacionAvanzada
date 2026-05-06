package com.laboratorio.streams.controller;

import com.laboratorio.streams.dto.TareaRequestDTO;
import com.laboratorio.streams.model.entity.EstadoTarea;
import com.laboratorio.streams.service.TareaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public ResponseEntity<?> listar(
            @RequestParam(required = false) EstadoTarea estado,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        if (estado != null) {
            return ResponseEntity.ok(tareaService.listarPorEstado(estado));
        }

        if (page != null && size != null) {
            return ResponseEntity.ok(tareaService.listarPaginado(PageRequest.of(page, size)));
        }

        return ResponseEntity.ok(tareaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tareaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody TareaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody TareaRequestDTO dto) {
        return ResponseEntity.ok(tareaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/resumen")
    public ResponseEntity<?> resumen() {
        return ResponseEntity.ok(tareaService.resumenPorEstado());
    }
}