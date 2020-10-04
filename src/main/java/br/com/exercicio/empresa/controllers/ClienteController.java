package br.com.exercicio.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exercicio.empresa.entities.Cliente;
import br.com.exercicio.empresa.repositories.ClienteRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	
	@GetMapping()
	public Iterable<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	@PostMapping
	public void addCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
	}
}
