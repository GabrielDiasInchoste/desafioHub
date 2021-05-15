package com.br.gabrieldias.desafiohub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gabrieldias.desafiohub.dto.ContaDTO;
import com.br.gabrieldias.desafiohub.entity.ContaEntity;
import com.br.gabrieldias.desafiohub.services.ContaService;

@RestController
@RequestMapping("/v1/")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@GetMapping(value = "conta/{contaId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContaEntity> getConta(@PathVariable(value = "contaId") Integer contaId) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
				.body(contaService.getConta(contaId));
	}

	@PostMapping(value = "conta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContaEntity> postConta(@RequestBody ContaDTO contaDto) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
				.body(contaService.postConta(contaDto));
	}
	
	@DeleteMapping(value = "conta/{contaId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteConta(@PathVariable(value = "contaId") Integer contaId) throws Exception {
		
		contaService.deleteConta(contaId);
		
		return ResponseEntity.noContent().build();
	}

}
