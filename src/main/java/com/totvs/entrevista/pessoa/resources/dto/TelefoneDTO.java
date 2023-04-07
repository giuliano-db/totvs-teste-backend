package com.totvs.entrevista.pessoa.resources.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.totvs.entrevista.pessoa.util.validation.CaracteresUnicos;


public class TelefoneDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Número do telefone deve ser adicionado")
	@CaracteresUnicos
	private String numero;
	
	public TelefoneDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TelefoneDTO(Integer id, @NotEmpty(message = "Número do telefone deve ser adicionado") String numero) {
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

}
