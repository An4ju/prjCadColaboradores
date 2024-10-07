package com.example.demo.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Colaborador;
import com.example.demo.services.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	private final ColaboradorService colaboradorservice;
	
	@Autowired
	public ColaboradorController(ColaboradorService colaboradorservice) {
		this.colaboradorservice = colaboradorservice;
	}
	
	@PostMapping
	public Colaborador createColaborador(@RequestBody Colaborador colaborador) {
		return colaboradorservice.saveColaborador(colaborador);
	}
	
	// taz todos os registros
	@GetMapping
	public List<Colaborador> getColaboradorAll(){
		return colaboradorservice.getAllColaborador();
	}

	// traz somente o objeto especifico pelo id
	@GetMapping("/{id}")
	public Colaborador getColaborador(@PathVariable Long id) {
		return colaboradorservice.getColaboradorById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteColaborador(@PathVariable Long id) {
		colaboradorservice.deleteColaborador(id);
	}
}