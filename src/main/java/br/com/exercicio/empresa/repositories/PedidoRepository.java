package br.com.exercicio.empresa.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.exercicio.empresa.entities.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer>{

}
