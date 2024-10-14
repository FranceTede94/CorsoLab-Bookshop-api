package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import it.corso.dao.CategoriaDao;
import it.corso.helpers.ResponseManager;
import it.corso.model.Categoria;
import jakarta.persistence.EntityNotFoundException;


@Service
public class CategoriaServiceImp implements CategoriaService {

	@Autowired
	CategoriaDao categoriaDao;
	
	
	@Override
	public List<Categoria> getAll() {
		List<Categoria> categoria = (List<Categoria>) categoriaDao.findAll(Sort.by(Sort.Direction.ASC, "nome")); 
		return categoria;
	}
	
	@Override
	public Categoria saveCategoria(Categoria categoria) {
	return categoriaDao.save(categoria);
	
	}
	
	@Override
	public Categoria getCategoriaById(int id) {
	Optional<Categoria> categoriaOptional = categoriaDao.findById(id);
		
		if(categoriaOptional.isPresent()) {
			return categoriaOptional.get();
		}
		throw new EntityNotFoundException("Non trovato");
	}

	@Override
	public void deleteCategoria(Categoria categoria) {
		categoriaDao.delete(categoria);		
	}
	
	
	@Override
	public void modificaCategoria(Categoria categoria) {
		categoriaDao.save(categoria);		
	}
	
	
	@Override
	public ObjectNode deleteCategoriaById(int id) {
		Optional<Categoria> categoriaOptional = categoriaDao.findById(id);
		
		if(categoriaOptional.isPresent()) {
			categoriaDao.delete(categoriaOptional.get());
			ResponseManager man = new ResponseManager(200,"cancellazione categoria" );
			return man.getResponse();
		}
		ResponseManager man = new ResponseManager(404,"categoria non trovato" );
		return man.getResponse();
	}

	
	@Override
	public ObjectNode updateCategoriaById(int id, Categoria categoria) {
		Optional<Categoria> categoriaOptional = categoriaDao.findById(id);
		ResponseManager responseManager;
		
		if(categoriaOptional.isPresent()) {
			
				if(categoriaOptional.get().getId() == categoria.getId()) {
					categoriaDao.save(categoria);
					responseManager = new ResponseManager(200,"categoria modificata" );
					return responseManager.getResponse();
				}
				else {
					responseManager = new ResponseManager(404,"categoria non corrispondente" );
					return responseManager.getResponse();
				}
		}
		else	{
			ResponseManager man = new ResponseManager(404,"categoria non trovata" );
			return man.getResponse();
				
		}
		
	}


	
}
