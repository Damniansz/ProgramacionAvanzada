package com.laboratorio.streams.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ManejadorGlobalExcepciones {

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> manejarNoEncontrado(RecursoNoEncontradoException ex) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("estado", 404);
        error.put("mensaje", ex.getMessage());
        error.put("fecha", LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> manejarValidaciones(MethodArgumentNotValidException ex) {
        Map<String, Object> error = new LinkedHashMap<>();
        Map<String, String> detalles = new LinkedHashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(e ->
                detalles.put(e.getField(), e.getDefaultMessage())
        );

        error.put("estado", 400);
        error.put("mensaje", "Error de validación");
        error.put("errores", detalles);
        error.put("fecha", LocalDateTime.now());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> manejarErrorGeneral(Exception ex) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("estado", 500);
        error.put("mensaje", "Error interno del servidor");
        error.put("fecha", LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}