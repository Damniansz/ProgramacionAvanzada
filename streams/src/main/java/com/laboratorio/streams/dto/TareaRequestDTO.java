package com.laboratorio.streams.dto;

import com.laboratorio.streams.model.entity.EstadoTarea;
import jakarta.validation.constraints.*;

public class TareaRequestDTO {

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 255, message = "La descripción no debe superar los 255 caracteres")
    private String descripcion;

    @NotNull(message = "El estado es obligatorio")
    private EstadoTarea estado;

    @NotNull(message = "La prioridad es obligatoria")
    @Min(value = 1, message = "La prioridad mínima es 1")
    @Max(value = 5, message = "La prioridad máxima es 5")
    private Integer prioridad;

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public Integer getPrioridad() {
        return prioridad;
    }
}