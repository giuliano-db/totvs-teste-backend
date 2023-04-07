package com.totvs.entrevista.pessoa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.entrevista.pessoa.domain.Pessoa;
import com.totvs.entrevista.pessoa.resources.dto.PessoaDTO;
import com.totvs.entrevista.pessoa.resources.dto.TelefoneDTO;
import com.totvs.entrevista.pessoa.service.PessoaService;

@SpringBootTest
@AutoConfigureMockMvc
class PessoaApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
	private PessoaService service;

	@Test
	void validarTamanhoNome() throws JsonProcessingException, Exception {
		PessoaDTO dto = new PessoaDTO();
		dto.setBairro("bairro");
		dto.setEndereco("endereço");
		dto.setNome("123456789");
		
		TelefoneDTO telDto = new TelefoneDTO(null, "23");
		List<TelefoneDTO> lista = new ArrayList<>();
		lista.add(telDto);
		
		dto.setTelefones(lista);
		
		mockMvc.perform(post("/pessoas")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().is4xxClientError())
	            .andExpect(content().string(containsString("O tamanho deve ser entre 10 e 50")))
				.andExpect(content().string(containsString("nome")));
	            	    
	    
		List<Pessoa> listaPessoa = service.findAll();
		
		Assertions.assertThat(listaPessoa.size() == 0);
		
	}
	
	@Test
	void validarTelefoneUsado() throws JsonProcessingException, Exception {
		PessoaDTO dto = new PessoaDTO();
		dto.setBairro("bairro");
		dto.setEndereco("endereço");
		dto.setNome("1234567890");
		
		TelefoneDTO telDto = new TelefoneDTO(null, "123456");
		List<TelefoneDTO> lista = new ArrayList<>();
		lista.add(telDto);
		
		dto.setTelefones(lista);
		
		mockMvc.perform(post("/pessoas")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().isCreated());
	            	    
	    
		List<Pessoa> listaPessoa = service.findAll();
		
		Assertions.assertThat(listaPessoa.size() == 1);
		dto.setId(listaPessoa.get(0).getId());
		
		PessoaDTO dto2 = new PessoaDTO();
		dto2.setBairro("bairro");
		dto2.setEndereco("endereço");
		dto2.setNome("1234567890");
		
		TelefoneDTO telDto2 = new TelefoneDTO(null, "123456");
		List<TelefoneDTO> lista2 = new ArrayList<>();
		lista2.add(telDto2);
		
		dto2.setTelefones(lista2);
		
		
		mockMvc.perform(post("/pessoas")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(dto2)))
				.andExpect(status().is4xxClientError())
	            .andExpect(content().string(containsString("Telefone deve ser")))
				.andExpect(content().string(containsString("Telefone")));
		
		service.delete(dto.getId());
		listaPessoa = service.findAll();
		
		Assertions.assertThat(listaPessoa.size() == 0);
		
	}
	
	@Test
	void validarTelefoneNullo() throws JsonProcessingException, Exception {
		PessoaDTO dto = new PessoaDTO();
		dto.setBairro("bairro");
		dto.setEndereco("endereço");
		dto.setNome("1234567890");
		
		TelefoneDTO telDto = new TelefoneDTO(null, "");
		List<TelefoneDTO> lista = new ArrayList<>();
		lista.add(telDto);
		
		dto.setTelefones(lista);
		
		mockMvc.perform(post("/pessoas")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().is4xxClientError())
	            .andExpect(content().string(containsString("mero do telefone deve ser adicionado")));
	            	    
	    
		List<Pessoa> listaPessoa = service.findAll();
		
		Assertions.assertThat(listaPessoa.size() == 0);
		
		
	}

}
