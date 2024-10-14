package it.corso.dao;

import org.springframework.data.repository.CrudRepository;
import it.corso.model.Autore;

public interface AutoreDao extends CrudRepository<Autore, Integer>{

	
	Iterable<Autore> findAll(org.springframework.data.domain.Sort sort);

}
