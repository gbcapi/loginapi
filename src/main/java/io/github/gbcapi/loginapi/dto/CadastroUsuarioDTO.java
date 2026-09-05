package io.github.gbcapi.loginapi.dto;

public record CadastroUsuarioDTO(
		String nome,
		String email,
		String senha,
		String confirmarSenha
	) {}