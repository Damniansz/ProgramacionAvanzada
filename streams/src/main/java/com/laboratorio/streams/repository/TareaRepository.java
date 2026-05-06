package com.laboratorio.streams.repository;

import com.laboratorio.streams.model.entity.EstadoTarea;
import com.laboratorio.streams.model.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

    List<Tarea> findByEstado(EstadoTarea estado);

    @Query("SELECT t.estado, COUNT(t) FROM Tarea t GROUP BY t.estado")
    List<Object[]> contarTareasPorEstado();
}