package br.com.exercicio.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exercicio.empresa.entities.Pedido;
import br.com.exercicio.empresa.repositories.PedidoRepository;

@RestController
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@GetMapping
	public Iterable<Pedido> mostrarPedidos(){
		return pedidoRepository.findAll();
	}
	
	
	@PostMapping()
	public void adicionarPedido(@RequestBody Pedido pedido) {
		pedidoRepository.save(pedido);
	}
}
