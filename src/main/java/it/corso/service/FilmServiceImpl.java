package it.corso.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.FilmDao;
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
	public Map<String, List<Film>> getFilmByGenere(List<Film> films){
		List<String> generi = films.stream()
				.map(Film::getGenere)
				.collect(Collectors.toList());
		
		List<Film> filmsPerGenere = filmDao.findByGenereIn(generi);
		return filmsPerGenere.stream()
				.collect(Collectors.groupingBy(Film::getGenere, Collectors.toList()));
	}





	@Override
	public Film getFilmByID(int id) {
		return filmDao.findById(id).get();
	}


}
