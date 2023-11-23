package com.senai.desafio.pedro.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.senai.desafio.pedro.Repositories.FuncionarioRepository;
import com.senai.desafio.pedro.entities.Funcionarios;


public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public Funcionarios saveFuncionarios (Funcionarios funcionarios) {
		return funcionarioRepository.save(funcionarios);
	}

	public List<Funcionarios> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public Funcionarios getFuncionarios(Long funcodigo) {
		return funcionarioRepository.findById(funcodigo).orElse(null);

	}

	public void deleteFuncionarios(long funcodigo) {
		funcionarioRepository.deleteById(funcodigo);

	}

	public Funcionarios updateFuncionarios(Long funcodigo, Funcionarios novoFuncionarios) {
		Optional<Funcionarios> funcionariosOptional = funcionarioRepository.findById(funcodigo);
		if (funcionariosOptional.isPresent()) {
			Funcionarios funcionariosExistente = funcionariosOptional.get();
			funcionariosExistente.setFuncodigo(novoFuncionarios.getFuncodigo());
			funcionariosExistente.setFunnome(novoFuncionarios.getFunnome());
			funcionariosExistente.setFunnascimento(novoFuncionarios.getFunnascimento());
			funcionariosExistente.setFunsalario(novoFuncionarios.getFunsalario());
			return funcionarioRepository.save(funcionariosExistente);
		} else {
			return null;
		}
	}

}

