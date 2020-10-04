package br.com.exercicio.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exercicio.empresa.entities.Funcionario;
import br.com.exercicio.empresa.repositories.FuncionarioRepository;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping()
	public Iterable<Funcionario> mostrarTodos(){
		return funcionarioRepository.findAll();
	}
	
	@PostMapping
	public void adicionarFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	
	@DeleteMapping("/{id}")
	public void demitirFuncionario(@PathVariable int id) {
		funcionarioRepository.deleteById(id);
	}
	
	@PutMapping("/{idfuncionario}")
	public Funcionario alterarSalario(@PathVariable int idfuncionario, @RequestBody Funcionario dadosFunc) throws Exception{
		
		Funcionario funcDB = funcionarioRepository.findById(idfuncionario)
				.orElseThrow(() -> new IllegalAccessException());
		
		if(!dadosFunc.getSalario().isEmpty()) {
			funcDB.setSalario(dadosFunc.getSalario());
		}

		funcionarioRepository.save(funcDB);
		return funcDB;
	}
	
}
