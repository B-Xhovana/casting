package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.AttoreDao;
import it.corso.model.Attore;
import it.corso.model.Film;

@Service
public class AttoreServiceImpl implements AttoreService {
	
	@Autowired
	private AttoreDao attoreDao;
	
	@Override
	public void registraAttore(Attore attore) {
		attoreDao.save(attore);

	}

	@Override
	public List<Attore> getAttori() {
		return (List<Attore>) attoreDao.findAll();
	}

	@Override
	public Attore getAttoreById(int id) {
		
		return attoreDao.findById(id).get();
	}
	
	@Override
	public void cancellaAttore(Attore attore) {
		attoreDao.delete(attore);

	}
	
	@Override
    public List<Film> getFilmByAttoreId(int attoreId) {
        Attore attore = attoreDao.findById(attoreId).orElse(null);
        return (attore != null) ? attore.getFilms() : null;
    }

}
