# Repaso Reactivo

## Descripción

Repaso Reactivo es una aplicación desarrollada con Spring Boot cuyo objetivo es demostrar las diferencias entre el modelo tradicional bloqueante y el modelo reactivo no bloqueante. La aplicación implementa endpoints REST utilizando Spring Web y Spring WebFlux, además de persistencia reactiva mediante Spring Data R2DBC y una base de datos H2 en memoria.

El proyecto permite comparar el comportamiento de ambos paradigmas utilizando una entidad Producto y aplicando conceptos de programación funcional como expresiones lambda y Streams API.

---

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.x
- Spring Web
- Spring WebFlux
- Project Reactor
- Spring Data R2DBC
- H2 Database
- Maven

---

## Arquitectura del proyecto

```text
src/main/java/com/espe/repaso_reactivo

├── controller
│   ├── ProductoController.java
│   └── ProductoReactivoController.java
│
├── dto
│   └── ProductoDto.java
│
├── model
│   └── Producto.java
│
├── repository
│   └── ProductoRepository.java
│
├── service
│   └── ProductoService.java
│
└── RepasoReactivoApplication.java

src/main/resources

├── application.properties
├── schema.sql
└── data.sql