package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Film;

public interface FilmDao extends CrudRepository<Film, Integer>{
	List<Film> findByGenereIn(List<String> generi);
	//Map<String, List<Film>> findByGenere(List<String> films, String genere);
	@Query(value = "SELECT DISTINCT genere FROM film", nativeQuery = true)
	String[] generiArray();
}