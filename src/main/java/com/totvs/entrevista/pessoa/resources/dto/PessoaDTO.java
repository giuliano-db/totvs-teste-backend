package com.totvs.entrevista.pessoa.resources.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class PessoaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=10, max=50,message="O tamanho deve ser entre 10 e 50")
	private String nome;
	
	private String endereco;
	
	private String bairro;
	
	@Size(min=1,message = "Necessário ao menos um telefone")
	private List<TelefoneDTO> telefones;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}

}
