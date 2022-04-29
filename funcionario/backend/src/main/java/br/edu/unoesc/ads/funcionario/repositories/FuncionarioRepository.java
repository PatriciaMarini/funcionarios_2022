package br.edu.unoesc.ads.funcionario.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.ads.funcionario.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	@Query("select p from Funcionario p where p.salario >= :salario")
	List<Funcionario> porSalario(@Param("salario") BigDecimal salario);
}