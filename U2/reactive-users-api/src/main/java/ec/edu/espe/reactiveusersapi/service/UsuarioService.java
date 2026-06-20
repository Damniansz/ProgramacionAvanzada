package ec.edu.espe.reactiveusersapi.service;

import ec.edu.espe.reactiveusersapi.model.Usuario;
import ec.edu.espe.reactiveusersapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

//    public Flux<Usuario> obtenerTodos() {
//        return repository.findAll();
//    }

    public Flux<Usuario> obtenerTodos() {

        return repository.findAll()
                .doOnSubscribe(
                        s -> System.out.println("Subscriber conectado"))
                .doOnNext(
                        u -> System.out.println("Usuario enviado: "
                                + u.getNombre()))
                .doOnComplete(
                        () -> System.out.println("Flujo completado"));
    }

    public Mono<Usuario> obtenerPorId(String id) {
        return repository.findById(id);
    }

    public Mono<Usuario> crear(Usuario usuario) {
        return repository.save(usuario);
    }

    public Mono<Usuario> actualizar(String id, Usuario usuario) {

        return repository.findById(id)
                .flatMap(existente -> {

                    existente.setNombre(usuario.getNombre());
                    existente.setEmail(usuario.getEmail());
                    existente.setEdad(usuario.getEdad());

                    return repository.save(existente);
                });
    }

    public Mono<Void> eliminar(String id) {
        return repository.deleteById(id);
    }
}