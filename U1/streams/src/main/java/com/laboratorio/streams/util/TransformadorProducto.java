package com.laboratorio.streams.util;

import com.laboratorio.streams.model.Producto;

@FunctionalInterface
public interface TransformadorProducto {

    Producto transformar(Producto producto);

    static TransformadorProducto aplicarDescuento(double porcentaje) {
        return producto -> {
            double nuevoPrecio = producto.getPrecio() - (producto.getPrecio() * porcentaje / 100);

            return new Producto(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getCategoria(),
                    nuevoPrecio,
                    producto.getStock(),
                    producto.getActivo()
            );
        };
    }

    static TransformadorProducto desactivar() {
        return producto -> new Producto(
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getPrecio(),
                producto.getStock(),
                false
        );
    }
}