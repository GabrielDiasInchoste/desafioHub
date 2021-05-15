package com.br.gabrieldias.desafiohub.dto;

import com.br.gabrieldias.desafiohub.entity.PessoaEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaDTO {

	private PessoaEntity pessoa;
	
	private String nome;
	
}
