package br.edu.unoesc.ads.funcionario.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.unoesc.ads.funcionario.dto.FuncionarioDTO;
import br.edu.unoesc.ads.funcionario.entities.Funcionario;
import br.edu.unoesc.ads.funcionario.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
@Autowired
private FuncionarioRepository repositorio;
@Transactional(readOnly = true)
public Page<FuncionarioDTO> findAll(Pageable pageable) {
Page<Funcionario> resultado = repositorio.findAll(pageable);
Page<FuncionarioDTO> pagina = resultado.map(x -> new FuncionarioDTO(x));
return pagina;
}
@Transactional(readOnly = true)
public FuncionarioDTO findById(Long id) {
	Funcionario resultado = repositorio.findById(id).get();
	FuncionarioDTO dto = new FuncionarioDTO(resultado);
return dto;
}
}


