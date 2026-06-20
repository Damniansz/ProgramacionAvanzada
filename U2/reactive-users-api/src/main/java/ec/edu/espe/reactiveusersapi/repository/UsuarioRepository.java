package ec.edu.espe.reactiveusersapi.repository;

import ec.edu.espe.reactiveusersapi.model.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UsuarioRepository
        extends ReactiveCrudRepository<Usuario,String> {

    Mono<Usuario> findByEmail(String email);

    Mono<Boolean> existsByEmail(String email);
}