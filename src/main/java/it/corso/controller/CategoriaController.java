package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Categoria;
import it.corso.service.CategoriaService;

@RestController
@RequestMapping("categorie")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	
	@GetMapping("/all") // all significa tutti gli autori
	public List<Categoria> getCategoria() {
		return categoriaService.getAll();
	}
	

	@GetMapping("/{id}") // {id} significa il singolo autore che stai cercando
	public Categoria getCategoriaById(@PathVariable ("id") int id) {
		return categoriaService.getCategoriaById(id);
	}
	
	
	@PostMapping("/insert") // save significa  che stai inserendo un autore
	public Categoria saveCategoria(@RequestBody Categoria categoria) {
		return categoriaService.saveCategoria(categoria);
	}
	
	@DeleteMapping("/delete/{id}")
	public ObjectNode deleteCategoria(@PathVariable ("id") int id) {
		ObjectNode res = categoriaService.deleteCategoriaById(id);
		return res;
	}
	
	@PutMapping("update/{id}")
	public ObjectNode updateCategoria(@PathVariable ("id") int id, @RequestBody Categoria categoria) {
		 return categoriaService.updateCategoriaById(id, categoria);
	}
	
	
	
	
	
	
	

}
