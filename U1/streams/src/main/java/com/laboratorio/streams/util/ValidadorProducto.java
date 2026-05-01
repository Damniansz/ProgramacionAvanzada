package com.laboratorio.streams.util;

import com.laboratorio.streams.model.Producto;

@FunctionalInterface
public interface ValidadorProducto {

    boolean validar(Producto producto);

    static ValidadorProducto precioPositivo() {
        return producto -> producto.getPrecio() != null && producto.getPrecio() > 0;
    }

    static ValidadorProducto stockMinimo(int minimo) {
        return producto -> producto.getStock() != null && producto.getStock() >= minimo;
    }

    static ValidadorProducto activo() {
        return producto -> Boolean.TRUE.equals(producto.getActivo());
    }

    default ValidadorProducto and(ValidadorProducto otro) {
        return producto -> this.validar(producto) && otro.validar(producto);
    }
}