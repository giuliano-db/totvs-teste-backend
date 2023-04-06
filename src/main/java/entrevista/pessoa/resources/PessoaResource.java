package entrevista.pessoa.resources;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.totvs.entrevista.pessoa.domain.Pessoa;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Pessoa pessoa){
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(0).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
}
