package br.edu.unoesc.ads.funcionario.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.ads.funcionario.dto.FuncionarioDTO;
import br.edu.unoesc.ads.funcionario.entities.Funcionario;
import br.edu.unoesc.ads.funcionario.repositories.FuncionarioRepository;
import br.edu.unoesc.ads.funcionario.services.FuncionarioService;

	@RestController
	@RequestMapping(value="api")
	public class FuncionarioRESTController {
	@Autowired
	private FuncionarioService servico;
	@Autowired
	private FuncionarioRepository repositorio;
	@GetMapping(value = "/funcionario")
	public Page<FuncionarioDTO> findAll(Pageable pageable) {
	return servico.findAll(pageable);
	}
	@GetMapping(value = "/funcionario/{id}")
	public FuncionarioDTO findById(@PathVariable Long id) {
	return servico.findById(id);
	}
	// Incluir Funcionario
	@PostMapping("/funcionario")
	public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
	return repositorio.save(funcionario);
	}
	// Atualizar Funcionario
	@PutMapping("/funcionario")
	public Funcionario atualizarFuncionario(@RequestBody Funcionario funcionario) {
	return repositorio.save(funcionario);
	}
	@DeleteMapping("/funcionario")
	public void deletarProduto(@RequestBody Funcionario funcionario) {
	repositorio.delete(funcionario);
	}
	@GetMapping(value={"/funcionarioporsalario", "/funcionarioporsalario/{salario}"})
	public List<Funcionario> listarPorSalario(@PathVariable Optional<BigDecimal> salario) {
	return repositorio.porSalario(salario.orElse(BigDecimal.ZERO));
	}
	}

