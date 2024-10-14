package it.corso.dao;

import org.springframework.data.repository.CrudRepository;
import it.corso.model.Categoria;

public interface CategoriaDao extends CrudRepository<Categoria, Integer>{
	
	Iterable<Categoria> findAll(org.springframework.data.domain.Sort sort);

}
