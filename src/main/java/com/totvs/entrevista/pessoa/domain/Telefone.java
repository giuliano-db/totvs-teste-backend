package com.totvs.entrevista.pessoa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.totvs.entrevista.pessoa.util.validation.CaracteresUnicos;

import javax.persistence.ManyToOne;


@Entity
@Table(name = "telefone")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(unique = true)
	@NotEmpty(message = "Número do telefone deve ser adicionado")
	@CaracteresUnicos
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	
	public Telefone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Telefone(Integer id, @NotEmpty(message = "Número do telefone deve ser adicionado") String numero) {
		super();
		this.id = id;
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
