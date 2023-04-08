package com.totvs.entrevista.pessoa.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.totvs.entrevista.pessoa.resources.dto.PessoaDTO;
import com.totvs.entrevista.pessoa.service.PessoaService;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PessoaDTO pessoa){
		
		pessoa = service.insert(service.fromDto(pessoa));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value = "/{id}" , method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PessoaDTO pessoa){
		
		pessoa = service.update(service.fromDto(pessoa));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> listAll(){
		
		List<PessoaDTO> listDto = service.findAll().stream().map(x -> service.toDto(x)).toList(); 
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(value = "/{id}" , method=RequestMethod.GET)
	public ResponseEntity<PessoaDTO> findById(@PathVariable Integer id){
		PessoaDTO dto  = service.toDto(service.findById(id)); 
		return ResponseEntity.ok().body(dto);
		
	}
	
	@RequestMapping(value = "/{id}" , method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id); 
		
		return ResponseEntity.noContent().build();
		
	}
	
}
