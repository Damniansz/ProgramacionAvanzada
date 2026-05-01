package com.laboratorio.streams.controller;

import com.laboratorio.streams.model.Producto;
import com.laboratorio.streams.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/validos")
    public List<Producto> obtenerProductosValidos() {
        return service.obtenerProductosValidos();
    }

    @GetMapping("/descuento-tecnologia")
    public List<Producto> aplicarDescuentoTecnologia(@RequestParam double porcentaje) {
        return service.aplicarDescuentoTecnologia(porcentaje);
    }

    @GetMapping("/catalogo")
    public Map<String, List<String>> generarCatalogoAgrupado() {
        return service.generarCatalogoAgrupado();
    }
}