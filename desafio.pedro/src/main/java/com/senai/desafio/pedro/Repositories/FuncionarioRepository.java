package com.senai.desafio.pedro.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.desafio.pedro.entities.Funcionarios;

public interface FuncionarioRepository extends JpaRepository<Funcionarios, Long>{
	
}
