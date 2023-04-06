package com.totvs.entrevista.pessoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.entrevista.pessoa.domain.Pessoa;
import com.totvs.entrevista.pessoa.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public void insert(Pessoa obj) {
		obj.setId(null);
		repo.save(obj);
	}
}
