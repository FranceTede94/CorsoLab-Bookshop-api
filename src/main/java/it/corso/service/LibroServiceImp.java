package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dao.LibroDao;
import it.corso.helpers.ResponseManager;
import it.corso.model.Libro;
import jakarta.persistence.EntityNotFoundException;


@Service
public class LibroServiceImp implements LibroService {

	@Autowired
	LibroDao libroDao;
	
	@Override
	public List<Libro> getAll() {
		List<Libro> libro = (List<Libro>) libroDao.findAll(Sort.by(Sort.Direction.ASC, "titolo"));
		return libro;
	}
	
	@Override
	public Libro saveLibro(Libro libro) {
	  return libroDao.save(libro);
	
	}
	
	@Override
	public Libro getlibroById(int id) {
	Optional<Libro> libroOptional = libroDao.findById(id);
		
		if(libroOptional.isPresent()) {
			return libroOptional.get();
		}
		throw new EntityNotFoundException("Non trovato");
	}
	
	@Override
	public void deleteLibro(Libro libro) {
		libroDao.delete(libro);		
	}

	@Override
	public void modificaLibro(Libro libro) {
		libroDao.save(libro);		
	}
	
	
	@Override
	public ObjectNode deleteLibroById(int id) {
		Optional<Libro> libroOptional = libroDao.findById(id);
		
		if(libroOptional.isPresent()) {
			libroDao.delete(libroOptional.get());
			ResponseManager man = new ResponseManager(200,"cancellazione libro" );
			return man.getResponse();
		}
		ResponseManager man = new ResponseManager(404,"libro non trovato" );
		return man.getResponse();
	}
	

	@Override
	public ObjectNode updateLibroById(int id, Libro libro) {
		Optional<Libro> libroOptional = libroDao.findById(id);
		ResponseManager responseManager;
		
		if(libroOptional.isPresent()) {
			
				if(libroOptional.get().getId() == libro.getId()) {
					libroDao.save(libro);
					responseManager = new ResponseManager(200,"libro modificato" );
					return responseManager.getResponse();
				}
				else {
					responseManager = new ResponseManager(404,"libro non corrispondente" );
					return responseManager.getResponse();
				}
		}
		else	{
			ResponseManager man = new ResponseManager(404,"libro non trovato" );
			return man.getResponse();
				
		}
		
	}
	
}


