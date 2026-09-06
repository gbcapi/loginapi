package io.github.gbcapi.loginapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.gbcapi.loginapi.dto.CadastroUsuarioDTO;
import io.github.gbcapi.loginapi.dto.UsuarioResponseDTO;
import io.github.gbcapi.loginapi.model.Usuario;
import io.github.gbcapi.loginapi.service.UsuarioService;
import jakarta.validation.Valid;

// @RestController: diz ao Spring que esta classe recebe requisicoes HTTP
// e devolve respostas em JSON (nunca HTML)
@RestController
// @RequestMapping: define o "prefixo" de URL comum a todos os endpoints desta classe
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public UsuarioResponseDTO cadastrar(@Valid @RequestBody CadastroUsuarioDTO dto) {
		
		Usuario novoUsuario = new Usuario();
		
		novoUsuario.setNome(dto.nome());
		novoUsuario.setEmail(dto.email());
		novoUsuario.setSenha(dto.senha());

		Usuario usuarioSalvo = usuarioService.cadastrar(novoUsuario);

		UsuarioResponseDTO response = new UsuarioResponseDTO(
		    usuarioSalvo.getId(),
		    usuarioSalvo.getNome(),
		    usuarioSalvo.getEmail(),
		    "Cadastro realizado com sucesso."
		);

		return response;
	}
}