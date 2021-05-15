package com.br.gabrieldias.desafiohub.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONTA")
public class ContaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTA_ID_SEQ")
	@SequenceGenerator(name = "CONTA_ID_SEQ", sequenceName = "CONTA_ID_SEQ", allocationSize = 1)
	@Column(name = "CONTA_ID")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PESSOA_ID")
	private PessoaEntity pessoa;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "DATA_CRIACAO")
	private LocalDateTime dataCriacao;
	
	@Column(name = "SALDO")
	private Double saldo;

}




