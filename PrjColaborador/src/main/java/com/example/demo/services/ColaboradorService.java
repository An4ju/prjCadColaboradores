package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Colaborador;
import com.example.demo.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	private final ColaboradorRepository colaboradorrepository;
	
	@Autowired
	public ColaboradorService(ColaboradorRepository colaboradorrepository) {
		this.colaboradorrepository = colaboradorrepository;
	}

	//criação do colaborador
	public Colaborador saveColaborador(Colaborador colaborador) {
		return colaboradorrepository.save(colaborador);
	}
	//buscar colaborador
	public Colaborador getColaboradorById(Long id) {
		return colaboradorrepository.findById(id).orElse(null);
	}
	//procurar todos colaborador
	public List<Colaborador> getAllColaborador(){
		return colaboradorrepository.findAll();
	}
	
	//excluir os colaborador
	public void deleteColaborador(Long id) {
		colaboradorrepository.deleteById(id);
	}
}