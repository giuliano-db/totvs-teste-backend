package com.totvs.entrevista.pessoa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@SequenceGenerator(name = "pessoa_id_seq", sequenceName = "pessoa_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_id_seq")
	@Column(name = "id")
	private Integer id;
	
	private String nome;
	
	private String endereco;
	
	private String bairro;
	
	@OneToMany(mappedBy="pessoa")
	private Set<Telefone> listTelefones = new HashSet<>();
	
}
