package it.corso.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Libro;

public interface LibroService {
	
	List<Libro> getAll();
	
	Libro saveLibro(Libro libro);
	
	Libro getlibroById(int id);
    
    void deleteLibro(Libro libro);
    
    void modificaLibro(Libro libro);
    
	ObjectNode deleteLibroById(int id);

	ObjectNode updateLibroById(int id, Libro libro);
	
}

