package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Libro;
import it.corso.service.LibroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/libri")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	
	@GetMapping("/all") // All significa mi stampa tutti i libri
	public List<Libro> getLibro() {
		return libroService.getAll();
		
	}
	
	@GetMapping("/{id}")  // {id} significa che mi stampa il singolo libro richiesto
	public Libro getLibroById(@PathVariable int id) {
		return libroService.getlibroById(id);
	}
	
	
	@PostMapping("/insert") // insert significa che mi sta inserendo un libro
	public Libro saveLibro(@RequestBody Libro libro) {
	    return libroService.saveLibro(libro);
	}
	
	
	@DeleteMapping("/delete/{id}")  // delete significa che mi sta elimando un libro nella tabella libri
	public ObjectNode deleteLibro(@PathVariable ("id") int id) {
		ObjectNode res = libroService.deleteLibroById(id);
		return res;
	}
	

	@PutMapping("/update/{id}")  // update significa che mi sta elimando un libro nella tabella libri
	public ObjectNode updateLibro(@PathVariable ("id") int id, @RequestBody Libro libro) {
		ObjectNode res = libroService.updateLibroById(id, libro);
		return res;
	}
	
	
	

}

