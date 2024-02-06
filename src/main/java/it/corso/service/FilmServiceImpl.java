package it.corso.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.FilmDao;
import it.corso.model.Attore;
import it.corso.model.Film;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmDao filmDao;
	
	@Override
	public List<Film> getFilms() {	
		return (List<Film>) filmDao.findAll();
	}

	
	@Override
	public Film getFilmById(int id) {		
		return filmDao.findById(id).get();
	}

	@Override
	public Map<String, List<Film>> getFilmByGenere(List<Film> films) {
		//ordino i film per genere
		Map<String, List<Film>> filmPerGenere = films.stream()
          .collect(Collectors.groupingBy(Film::getGenere));	
     	//ordino i film, divisi per genere, per data di uscita in ordine descrescente
		filmPerGenere.forEach((genere, filmList) ->
        filmList.sort(Comparator.comparing(Film::getDataUscita).reversed()));
     	return filmPerGenere;
	}

	@Override
	public List<Attore> getCast(int id) {
		Film film = filmDao.findById(id).orElse(null);	
		return film.getAttori();
	}
}
