package io.github.gbcapi.loginapi.dto;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String email,
    String mensagem
) {}