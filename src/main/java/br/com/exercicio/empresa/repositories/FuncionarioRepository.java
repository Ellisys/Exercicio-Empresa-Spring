package br.com.exercicio.empresa.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.exercicio.empresa.entities.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{

}
