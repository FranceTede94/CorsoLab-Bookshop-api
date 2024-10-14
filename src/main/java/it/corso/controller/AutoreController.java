package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Autore;
import it.corso.service.AutoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/autori")
public class AutoreController {
	
	@Autowired
	AutoreService autoreService;
	
	@GetMapping("/all") // all significa tutti gli autori
	public List<Autore> getAutore() {
		return autoreService.getAll();
	}
	
	@GetMapping("/{id}") // {id} significa il singolo autore che stai cercando
	public Autore getAutoreById(@PathVariable ("id") int id) {
		return autoreService.getAutoreById(id);
	}
	
	@PostMapping("/insert") // insert significa  che stai inserendo un autore
	public Autore saveAutore(@RequestBody Autore autore) {
		return autoreService.saveAutore(autore);
	}
	
	@DeleteMapping("/delete/{id}")
	public ObjectNode deleteAutore(@PathVariable ("id") int id) {
		ObjectNode res = autoreService.deleteAutoreById(id);
		return res;
	}
	
	@PutMapping("/update/{id}")
	public ObjectNode updateAutore(@PathVariable("id") int id, @RequestBody Autore autore) {
		ObjectNode res = autoreService.updateAutoreById(id, autore);
		return res;
	}
	

}
