package br.edu.unoesc.ads.funcionario.dto;

import java.math.BigDecimal;

import br.edu.unoesc.ads.funcionario.entities.Funcionario;

public class FuncionarioDTO {
	private Long id;
	private String nome;
	private Long idade;
	private String profissao;
	private BigDecimal salario;
	
	public FuncionarioDTO() {
	}
	
	
	public FuncionarioDTO(Long id, String nome, Long idade, String profissao, BigDecimal salario) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.profissao = profissao;
		this.salario = salario;
		
	}

	
	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.idade = funcionario.getIdade();
		this.profissao = funcionario.getProfissao();
		this.salario = funcionario.getSalario();
		}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}


}
