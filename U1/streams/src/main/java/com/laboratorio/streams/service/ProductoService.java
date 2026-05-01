package com.laboratorio.streams.service;

import com.laboratorio.streams.model.Producto;
import com.laboratorio.streams.repository.ProductoRepository;
import com.laboratorio.streams.util.FormateadorProducto;
import com.laboratorio.streams.util.TransformadorProducto;
import com.laboratorio.streams.util.ValidadorProducto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> obtenerProductosValidos() {
        ValidadorProducto validador = ValidadorProducto.precioPositivo()
                .and(ValidadorProducto.activo());

        return repo.findAll()
                .stream()
                .filter(validador::validar)
                .collect(Collectors.toList());
    }

    public List<Producto> aplicarDescuentoTecnologia(double porcentaje) {
        TransformadorProducto descuento = TransformadorProducto.aplicarDescuento(porcentaje);

        return repo.findAll()
                .stream()
                .filter(producto -> producto.getCategoria().equalsIgnoreCase("Tecnología"))
                .map(descuento::transformar)
                .collect(Collectors.toList());
    }

    public Map<String, List<String>> generarCatalogoAgrupado() {
        FormateadorProducto formateador = FormateadorProducto.resumen();

        return repo.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.mapping(formateador::formatear, Collectors.toList())
                ));
    }
}