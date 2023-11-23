package com.senai.desafio.pedro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.senai.desafio.pedro.Services.FuncionarioService;
import com.senai.desafio.pedro.entities.Funcionarios;


public class FuncionarioController {
	@Autowired
	private final FuncionarioService funcionarioService;

	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	@GetMapping("/home")
	public String paginainicial() {
		return "index";

	}


	@PostMapping
	public Funcionarios createFuncionarios(@RequestBody Funcionarios funcionarios) {
		return funcionarioService.saveFuncionarios(funcionarios);

	}

	@GetMapping("/{funcodigo}")
	public ResponseEntity<Funcionarios> getFuncionarios(@PathVariable Long funcodigo) {
		Funcionarios funcionarios = funcionarioService.getFuncionarios(funcodigo);
		if (funcionarios != null) {
			return ResponseEntity.ok(funcionarios);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	
	@DeleteMapping("/{funcodigo}")
	public void deleteFuncionarios(@PathVariable Long funcodigo) {
		funcionarioService.deleteFuncionarios(funcodigo);
	}

	@GetMapping
	public ResponseEntity<List<Funcionarios>> getAllFuncionarios(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Funcionarios> funcionarios = funcionarioService.getAllFuncionarios();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(funcionarios);
	}

	@PutMapping("/{funcodigo}")
	public Funcionarios updateDepartamento(@PathVariable Long funcodigo, @RequestBody Funcionarios funcionarios) {
		return  funcionarioService.updateFuncionarios(funcodigo, funcionarios);
	}
}
