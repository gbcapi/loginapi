package io.github.gbcapi.loginapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import io.github.gbcapi.loginapi.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
	Optional<Usuario> findByEmail(String email);

}
