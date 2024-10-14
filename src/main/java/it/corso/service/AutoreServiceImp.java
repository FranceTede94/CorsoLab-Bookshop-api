package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dao.AutoreDao;
import it.corso.helpers.ResponseManager;
import it.corso.model.Autore;
import jakarta.persistence.EntityNotFoundException;


@Service
public class AutoreServiceImp implements AutoreService {

	@Autowired 
	private AutoreDao autoreDao;
	
	@Override
	public List<Autore> getAll() {
		List<Autore> autori = (List<Autore>) autoreDao.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		return autori;
	}
	
	@Override
	public Autore saveAutore(Autore autore) {
	return autoreDao.save(autore);
	
	}
	
	@Override
	public Autore getAutoreById(int id) {
	Optional<Autore> autoreOptional = autoreDao.findById(id);
		
		if(autoreOptional.isPresent()) {
			return autoreOptional.get();
		}
		throw new EntityNotFoundException("Non trovato");
	}

	@Override
	public void deleteAutore(Autore autore) {
		autoreDao.delete(autore);		
	}

	
	@Override
	public void modificaAutore(Autore autore) {
		autoreDao.save(autore);		
	}
	
	@Override
	public ObjectNode deleteAutoreById(int id) {
		Optional<Autore> autoreOptional = autoreDao.findById(id);
		
		if(autoreOptional.isPresent()) {
			autoreDao.delete(autoreOptional.get());
			ResponseManager man = new ResponseManager(200,"cancellazione autore" );
			return man.getResponse();
		}
		ResponseManager man = new ResponseManager(404,"autore non trovato" );
		return man.getResponse();
	}

	
	@Override
	public ObjectNode updateAutoreById(int id, Autore autore) {
		Optional<Autore> autoreOptional = autoreDao.findById(id);
		ResponseManager responseManager;
		
		if(autoreOptional.isPresent()) {
			
				if(autoreOptional.get().getId() == autore.getId()) {
					autoreDao.save(autore);
					responseManager = new ResponseManager(200,"autore modificato" );
					return responseManager.getResponse();
				}
				else {
					responseManager = new ResponseManager(404,"autore non corrispondente" );
					return responseManager.getResponse();
				}
		}
		else	{
			ResponseManager man = new ResponseManager(404,"autore non trovato" );
			return man.getResponse();
				
		}
		
	}

	
	
}