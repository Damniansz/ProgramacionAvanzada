# Tarea 1 – Programación Funcional en Java

## Descripción

Este proyecto corresponde al desarrollo de la Tarea 1 de la asignatura, enfocada en la aplicación de conceptos fundamentales de programación funcional en Java. Se abordaron temas como expresiones lambda, interfaces funcionales estándar del paquete `java.util.function`, creación de interfaces funcionales personalizadas y composición de funciones mediante `andThen()` y `compose()`.

## Objetivos desarrollados

- Aplicar expresiones lambda como sustitutas de clases anónimas.
- Utilizar interfaces funcionales estándar de Java.
- Refactorizar código orientado a objetos hacia un estilo funcional.
- Diseñar una interfaz funcional personalizada.
- Implementar funciones de orden superior y composición de funciones.

## Estructura del proyecto

```
src
│
├── Producto.java
├── ProcesadorFuncional.java
├── CalculadoraTributo.java
├── Factura.java
├── PrincipalTributos.java
└── ComposicionFunciones.java
```

## Requisitos

- IntelliJ IDEA
- JDK 17 o superior
- Git instalado (para el control de versiones)

## Versión de Java utilizada

- Java: **JDK 21**
- IDE: **IntelliJ IDEA**
- Build System: **IntelliJ**

## Instrucciones para compilar y ejecutar

### Actividad 2 – Refactorización

Ejecutar la clase:

```text
ProcesadorFuncional.java
```

Resultado esperado:

```text
Productos caros:
[LAPTOP, MONITOR]

Method Reference
Laptop
Mouse
Monitor
```

### Actividad 3 – Interfaz funcional propia

Ejecutar la clase:

```text
PrincipalTributos.java
```

Se mostrarán los cálculos correspondientes al IVA del 15 %, retención del 2 % e impuesto variable aplicados sobre cinco facturas.

### Actividad 4 – Composición de funciones

Ejecutar la clase:

```text
ComposicionFunciones.java
```

Se visualizarán dos pipelines distintos construidos mediante `andThen()` y `compose()`, evidenciando cómo el orden de composición influye en el resultado.

## Autor

- Nombre  Aldo Saula
