package com.totvs.entrevista.pessoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.totvs.entrevista.pessoa.domain.Pessoa;
import com.totvs.entrevista.pessoa.repository.PessoaRepository;
import com.totvs.entrevista.pessoa.service.exceptions.TelefoneUnicoException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public void insert(Pessoa obj) {
		obj.setId(null);
		try {
			repo.save(obj);
			
		} catch (DataIntegrityViolationException e) {
			throw new TelefoneUnicoException("Telefone deve ser único");
		}
	}
}
