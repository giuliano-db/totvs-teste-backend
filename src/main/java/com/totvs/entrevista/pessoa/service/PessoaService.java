package com.totvs.entrevista.pessoa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.totvs.entrevista.pessoa.domain.Pessoa;
import com.totvs.entrevista.pessoa.domain.Telefone;
import com.totvs.entrevista.pessoa.repository.PessoaRepository;
import com.totvs.entrevista.pessoa.resources.dto.PessoaDTO;
import com.totvs.entrevista.pessoa.resources.dto.TelefoneDTO;
import com.totvs.entrevista.pessoa.service.exceptions.TelefoneUnicoException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public PessoaDTO insert(Pessoa obj) {
		obj.setId(null);
		try {
			repo.save(obj);
			
		} catch (DataIntegrityViolationException e) {
			throw new TelefoneUnicoException("Telefone deve ser único");
		}
		
		return toDto(obj);
	}
	
	public List<Pessoa> findAll() {
		return repo.findAll();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	
	public PessoaDTO toDto(Pessoa obj) {
		PessoaDTO dto = new PessoaDTO();
		dto.setBairro(obj.getBairro());
		dto.setEndereco(obj.getEndereco());
		dto.setNome(obj.getNome());
		dto.setId(obj.getId());
		
		if (obj.getTelefones() != null) {
			List<TelefoneDTO> listTelefone = obj.getTelefones().stream().map(x -> new TelefoneDTO( x.getId() ,x.getNumero() )).toList();
			dto.setTelefones(listTelefone);
		}
		 else {
				dto.setTelefones(new ArrayList<TelefoneDTO>());
			}
		return dto;
		
	}
	
	public Pessoa fromDto(PessoaDTO dto) {
		Pessoa obj = new Pessoa();
		obj.setBairro(dto.getBairro());
		obj.setEndereco(dto.getEndereco());
		obj.setNome(dto.getNome());
		obj.setId(dto.getId());
		
		if (dto.getTelefones() != null) {
			List<Telefone> listTelefone = dto.getTelefones().stream().map(x -> new Telefone( x.getId() ,x.getNumero() )).toList();
			obj.setTelefones(listTelefone);
		} else {
			obj.setTelefones(new ArrayList<Telefone>());
		}
		
		return obj;
		
	}
}
