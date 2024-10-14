package it.corso.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Autore;

public interface AutoreService {
	
    List<Autore> getAll();
    
    Autore saveAutore(Autore autore);
    
    Autore getAutoreById(int id);
    
    void deleteAutore(Autore autore);
       
    void modificaAutore(Autore autore);
    
    ObjectNode deleteAutoreById(int id);
    
    ObjectNode updateAutoreById(int id, Autore autore);
    
    
}