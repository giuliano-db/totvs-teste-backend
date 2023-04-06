package com.totvs.entrevista.pessoa.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.totvs.entrevista.pessoa.domain.Pessoa;
import com.totvs.entrevista.pessoa.service.PessoaService;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pessoa pessoa){
		service.insert(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
}
