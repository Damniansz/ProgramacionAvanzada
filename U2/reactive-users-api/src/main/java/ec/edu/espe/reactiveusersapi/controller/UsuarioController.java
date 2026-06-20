package ec.edu.espe.reactiveusersapi.controller;

import ec.edu.espe.reactiveusersapi.model.Usuario;
import ec.edu.espe.reactiveusersapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public Flux<Usuario> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Mono<Usuario> obtenerPorId(
            @PathVariable String id) {

        return service.obtenerPorId(id);
    }

    @GetMapping("/stream")
    public Flux<Integer> stream() {

        return Flux.range(1,1000000)
                .limitRate(100);
    }

    @PostMapping
    public Mono<Usuario> crear(
            @RequestBody Usuario usuario) {

        return service.crear(usuario);
    }

    @PutMapping("/{id}")
    public Mono<Usuario> actualizar(
            @PathVariable String id,
            @RequestBody Usuario usuario) {

        return service.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(
            @PathVariable String id) {

        return service.eliminar(id);
    }
}