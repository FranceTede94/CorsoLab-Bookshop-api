package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Libro;

public interface LibroDao extends CrudRepository<Libro, Integer>{

	
	Iterable<Libro> findAll(org.springframework.data.domain.Sort sort);

}