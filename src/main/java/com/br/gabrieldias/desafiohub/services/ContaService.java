package com.br.gabrieldias.desafiohub.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.br.gabrieldias.desafiohub.dto.ContaDTO;
import com.br.gabrieldias.desafiohub.entity.ContaEntity;
import com.br.gabrieldias.desafiohub.entity.PessoaEntity;
import com.br.gabrieldias.desafiohub.repository.ContaRepository;
import com.br.gabrieldias.desafiohub.repository.PessoaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public ContaEntity getConta(Integer contaId) throws Exception {
		log.info("ContaService.getConta - start - contaId: {}", contaId);

		Optional<ContaEntity> contaEntity = contaRepository.findById(contaId);
		if (contaEntity.isEmpty()) {
			throw new Exception("Id do Conta Invalida");
		}
		log.info("ContaService.getConta - end - contaId: {}", contaId);

		return contaEntity.get();
	}

	public ContaEntity postConta(ContaDTO contaDto) throws Exception {
		log.info("ContaService.postConta - start -- contaDto: {}", contaDto);
		
		if (!ObjectUtils.isEmpty(contaRepository.findByNome(contaDto.getNome()))) {
			throw new Exception("Nome da Conta Invalida");
		}
		ContaEntity contaEntity = new ContaEntity();
		contaEntity.setDataCriacao(LocalDateTime.now());
		contaEntity.setSaldo(0D);
		contaEntity.setNome(contaDto.getNome());
		
		PessoaEntity pessoa = pessoaRepository.save(contaDto.getPessoa());
		contaEntity.setPessoa(pessoa);
		
		ContaEntity conta = contaRepository.save(contaEntity);
		log.info("ContaService.postConta - end -- contaId: {}", conta.getId());

		return conta;
	}


	public void deleteConta(Integer contaId) throws Exception {
		log.info("ContaService.deleteConta - start -- contaId: {}", contaId);
		Optional<ContaEntity> contaEntity = contaRepository.findById(contaId);
		if (contaEntity.isEmpty()) {
			throw new Exception("Id do Conta Invalida");
		}
		contaRepository.deleteById(contaId);

		log.info("ContaService.deleteConta - end -- contaId: {}", contaId);

	}
}
