package com.br.gabrieldias.desafiohub.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PESSOA")
public class PessoaEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_ID_SEQ")
	@SequenceGenerator(name = "PESSOA_ID_SEQ", sequenceName = "PESSOA_ID_SEQ", allocationSize = 1)
	@Column(name = "PESSOA_ID")
	private Integer id;
	
	@Column(name = "TIPO_FISICA")
	private Boolean tipoFisica;
	
	@Column(name = "NOME")
	private String nome;

	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "DATA_NASCIMENTO")
	private LocalDateTime dataNascimento;

	@Column(name = "CNPJ")
	private String cnpj;
	
	@Column(name = "RAZAO_SOCIAL")
	private String razaoSocial;

}
