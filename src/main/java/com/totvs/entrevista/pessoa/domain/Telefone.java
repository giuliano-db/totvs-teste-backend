package com.totvs.entrevista.pessoa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "telefone")
public class Telefone {
	
	@Id
	@SequenceGenerator(name = "telefone_id_seq", sequenceName = "telefone_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefone_id_seq")
	@Column(name = "id")
	private Integer id;
	
	@Column(unique = true)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Pessoa pessoa;

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
