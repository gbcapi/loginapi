package io.github.gbcapi.loginapi.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.gbcapi.loginapi.model.Usuario;
import io.github.gbcapi.loginapi.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// Metodo responsavel por cadastrar um novo usuario
	public Usuario cadastrar(Usuario novoUsuario) {

	    // 1. Verifica se o e-mail ja existe ANTES de qualquer outro processamento
	    Optional<Usuario> usuarioExiste = usuarioRepository.findByEmail(novoUsuario.getEmail());
	    if (usuarioExiste.isPresent()) {
	        throw new IllegalArgumentException("Este e-mail ja esta cadastrado.");
	    }

	    // 2. Gera o hash da senha e substitui a senha em texto puro
	    String senhaComHash = passwordEncoder.encode(novoUsuario.getSenha());
	    novoUsuario.setSenha(senhaComHash);

	    // 3. Fixa o tipo do usuario (nunca aceito do formulario - protecao contra mass assignment)
	    novoUsuario.setTipo(Usuario.TipoUsuario.USER);

	    // 4. Preenche a data de criacao automaticamente
	    novoUsuario.setDataCriacao(LocalDateTime.now());

	    // 5. Salva no banco e devolve o usuario ja com o id gerado
	    return usuarioRepository.save(novoUsuario);
	}
	

}