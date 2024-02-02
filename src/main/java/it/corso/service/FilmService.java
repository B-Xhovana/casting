package it.corso.service;

import java.util.List;
import java.util.Map;

import it.corso.model.Attore;
import it.corso.model.Film;

public interface FilmService {
	
	List<Film> getFilms();
	
	
	Film getFilmByID(int id);
	//Medoto con stream per ottenere il catalogo dei film divisi per genenere in home page
	Map<String, List<Film>> getFilmByGenere(List<Film> films);
	
	
	List<Attore> getCastByFilmId(int id);
	
	
	
}