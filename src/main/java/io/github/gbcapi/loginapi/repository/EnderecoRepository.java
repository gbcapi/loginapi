package io.github.gbcapi.loginapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import io.github.gbcapi.loginapi.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	List<Endereco> findByUsuarioId(Long usuarioId);

}