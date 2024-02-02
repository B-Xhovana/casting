package it.corso.service;

import java.util.List;

import it.corso.model.Attore;
import it.corso.model.Film;

public interface AttoreService {
	
	void registraAttore(Attore attore);
	List<Attore> getAttori();
	Attore getAttoreById(int id);
	void cancellaAttore(Attore attore);
	List<Film> getFilmByAttoreId(int attoreId);
	
}
