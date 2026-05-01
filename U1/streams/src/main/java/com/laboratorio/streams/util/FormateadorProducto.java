package com.laboratorio.streams.util;

import com.laboratorio.streams.model.Producto;

@FunctionalInterface
public interface FormateadorProducto {

    String formatear(Producto producto);

    static FormateadorProducto resumen() {
        return producto -> String.format(
                "[%s] %s - $%.2f (%d unidades)",
                producto.getCategoria(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock()
        );
    }

    static FormateadorProducto etiqueta() {
        return producto -> String.format(
                "SKU-%d: %s | %s",
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria()
        );
    }
}