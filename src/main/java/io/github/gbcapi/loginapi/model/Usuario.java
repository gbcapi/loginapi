package io.github.gbcapi.loginapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

// @Entity: diz para o Hibernate que esta classe representa uma tabela no banco de dados
@Entity
public class Usuario {

	// @Id: marca este campo como a chave primaria da tabela
	// @GeneratedValue: o valor do id sera gerado automaticamente pelo banco (auto incremento)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	// @Column(unique = true): garante, no proprio banco, que nao existam dois
	// usuarios com o mesmo email cadastrado
	@Column(unique = true, nullable = false)
	private String email;

	// Vai guardar o HASH da senha, nunca a senha em texto puro
	// (trataremos disso na fase de cadastro)
	@Column(nullable = false)
	private String senha;

	// @Enumerated(EnumType.STRING): salva o NOME do valor do enum no banco
	// (ex: "ADMIN"), em vez do numero da posicao dele (mais seguro)
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoUsuario tipo;

	// Guarda a data e hora em que a conta foi criada (util para auditoria)
	private LocalDateTime dataCriacao;

	// Enum aninhado: so existe dentro do contexto de Usuario.
	// Representa os papeis/permissoes possiveis de um usuario no sistema.
	public enum TipoUsuario {
		USER,
		OPERADOR,
		ADMIN
	}

	// ===================================================
	// Getters e Setters
	// ===================================================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
	    this.dataCriacao = dataCriacao;
	}
	
}