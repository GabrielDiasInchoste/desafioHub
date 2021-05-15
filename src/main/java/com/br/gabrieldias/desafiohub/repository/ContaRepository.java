package com.br.gabrieldias.desafiohub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.gabrieldias.desafiohub.entity.ContaEntity;

public interface ContaRepository  extends JpaRepository<ContaEntity, Integer>{

	Optional<ContaEntity> findByNome(String nome);
	
}
