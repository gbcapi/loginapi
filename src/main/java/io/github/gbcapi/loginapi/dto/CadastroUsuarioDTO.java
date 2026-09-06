package io.github.gbcapi.loginapi.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastroUsuarioDTO(
	@NotBlank(message = "O nome e obrigatorio.")
	String nome,

	@NotBlank(message = "O email e obrigatorio.")
	String email,

	@NotBlank(message = "A senha e obrigatoria.")
	String senha,

	@NotBlank(message = "A confirmacao de senha e obrigatoria.")
	String confirmarSenha
) {}