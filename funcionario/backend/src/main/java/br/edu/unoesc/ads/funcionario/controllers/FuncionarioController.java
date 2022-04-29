package br.edu.unoesc.ads.funcionario.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.ads.funcionario.entities.Funcionario;
import br.edu.unoesc.ads.funcionario.repositories.FuncionarioRepository;

@Controller
@CrossOrigin(origins = "*")
public class FuncionarioController {	 
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/funcionario")
	public String listarFuncionarios(Model model) {
	SimpleDateFormat dateFormat = new SimpleDateFormat();
	Calendar cal = Calendar.getInstance();
	String sDataAux;
	dateFormat.applyPattern("dd 'de' MMMM 'de' yyyy");
	sDataAux = dateFormat.format(cal.getTime());
	model.addAttribute("data", LocalDateTime.now());
	model.addAttribute("dataExtenso", "<b>" + sDataAux + "</b>");
	model.addAttribute("funcionario", funcionarioRepository.findAll());
	return "lista_funcionario";
	}
	@GetMapping("/incluir_funcionario")
	public String formFuncionario(Model model) {
	model.addAttribute("funcionario", new Funcionario());
	model.addAttribute("adicionar", true);
	return "form_funcionario";
	}
	@PostMapping("/processa_incluir_funcionario")
	public String processaFormIncluirFuncionario(@Valid Funcionario funcionario, BindingResult resultado) {
	if (resultado.hasErrors()) {
	return "form_funcionario";
	}
	funcionarioRepository.save(funcionario);
	return "redirect:/funcionario";
	}
	@GetMapping("/alterar_funcionario/{id}")
	public String alterar(@PathVariable("id") long id, Model model) {
	Funcionario funcionario = funcionarioRepository.findById(id)
	.orElseThrow(() -> new IllegalArgumentException("Funcionario inválido Id:" + id));
	model.addAttribute("funcionario", funcionario);
	model.addAttribute("adicionar", false);
	return "form_funcionario";
	}
	@PostMapping("/processa_alterar_funcionario/{id}")
	public String processaFormAlterarFuncionario(@PathVariable("id") long id, @Valid Funcionario funcionario, BindingResult
	resultado, Model model) {
	if (resultado.hasErrors()) {
	funcionario.setId(id);
	return "form_funcionario";
	}
	funcionarioRepository.save(funcionario);
	return "redirect:/funcionario";
	}
	@GetMapping("/excluir_funcionario/{id}")
	public String remover(@PathVariable("id") long id, Model model) {
	Funcionario funcionario= funcionarioRepository.findById(id).get();
	funcionarioRepository.delete(funcionario);
	return "redirect:/funcionario";
	}
	}
	

