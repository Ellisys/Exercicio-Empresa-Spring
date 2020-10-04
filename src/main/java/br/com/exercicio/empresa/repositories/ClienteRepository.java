package br.com.exercicio.empresa.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.exercicio.empresa.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

}
