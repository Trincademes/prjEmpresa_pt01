package com.senai.desafio.pedro.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_funcionarios")
public class Funcionarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long funcodigo;
	@NotNull
	@NotBlank
private String funnome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	 private LocalDate funnascimento;
	@NotNull
	@NotBlank
private Double funsalario;

public String getFunnome() {
	return funnome;
}

public void setFunnome(String funnome) {
	this.funnome = funnome;
}

public Long getFuncodigo() {
	return funcodigo;
}

public void setFuncodigo(Long funcodigo) {
	this.funcodigo = funcodigo;
}

public LocalDate getFunnascimento() {
	return funnascimento;
}

public void setFunnascimento(LocalDate funnascimento) {
	this.funnascimento = funnascimento;
}

public Double getFunsalario() {
	return funsalario;
}

public void setFunsalario(Double funsalario) {
	this.funsalario = funsalario;
}
}
