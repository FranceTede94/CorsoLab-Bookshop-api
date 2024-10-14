package it.corso.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.model.Categoria;

public interface CategoriaService {
	
	List<Categoria> getAll();
	
	 Categoria saveCategoria(Categoria categoria);
	 
	 Categoria getCategoriaById(int id);
	    
	 void deleteCategoria (Categoria categoria);
	 
	 void modificaCategoria(Categoria categoria);
	 
	 ObjectNode deleteCategoriaById(int id);
	 
	 ObjectNode updateCategoriaById(int id, Categoria categoria);

}
