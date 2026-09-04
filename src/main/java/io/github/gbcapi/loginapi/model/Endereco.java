package io.github.gbcapi.loginapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// @Entity: diz para o Hibernate que esta classe representa uma tabela no banco de dados
@Entity
public class Endereco {

	// @Id: chave primaria do PROPRIO endereco (identifica este endereco especifico)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String rua;

	private String numero;

	@Column(nullable = false)
	private String cep;

	private String complemento;

	@Column(nullable = false)
	private String estado;

	@Column(nullable = false)
	private String cidade;

	// @Enumerated(EnumType.STRING): salva o NOME do valor do enum no banco
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoEndereco tipo;

	// @ManyToOne: MUITOS enderecos podem pertencer a UM usuario.
	// @JoinColumn: define o nome da coluna de chave estrangeira no banco (usuario_id)
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	// Enum aninhado: representa os tipos de endereco possiveis
	public enum TipoEndereco {
		CASA,
		TRABALHO
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}