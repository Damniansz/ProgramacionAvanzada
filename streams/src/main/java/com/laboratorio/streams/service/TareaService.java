package com.laboratorio.streams.service;

import com.laboratorio.streams.dto.TareaRequestDTO;
import com.laboratorio.streams.exception.RecursoNoEncontradoException;
import com.laboratorio.streams.model.entity.EstadoTarea;
import com.laboratorio.streams.model.entity.Tarea;
import com.laboratorio.streams.repository.TareaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

    public Page<Tarea> listarPaginado(Pageable pageable) {
        return tareaRepository.findAll(pageable);
    }

    public List<Tarea> listarPorEstado(EstadoTarea estado) {
        return tareaRepository.findByEstado(estado);
    }

    public Tarea buscarPorId(Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Tarea no encontrada con ID: " + id));
    }

    public Tarea crear(TareaRequestDTO dto) {
        Tarea tarea = new Tarea();
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setEstado(dto.getEstado());
        tarea.setPrioridad(dto.getPrioridad());
        return tareaRepository.save(tarea);
    }

    public Tarea actualizar(Long id, TareaRequestDTO dto) {
        Tarea tarea = buscarPorId(id);
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setEstado(dto.getEstado());
        tarea.setPrioridad(dto.getPrioridad());
        return tareaRepository.save(tarea);
    }

    public void eliminar(Long id) {
        Tarea tarea = buscarPorId(id);
        tareaRepository.delete(tarea);
    }

    public Map<String, Long> resumenPorEstado() {
        Map<String, Long> resumen = new LinkedHashMap<>();

        for (Object[] fila : tareaRepository.contarTareasPorEstado()) {
            resumen.put(fila[0].toString(), (Long) fila[1]);
        }

        return resumen;
    }
}