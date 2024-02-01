package it.corso.service;

import java.util.List;

import it.corso.model.Attore;

public interface AttoreService {
	
	void registraAttore(Attore attore);
	List<Attore> getAttori();
	Attore getAttoreById(int id);
	void cancellaAttore(Attore attore);
	
}
