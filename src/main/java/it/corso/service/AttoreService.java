package it.corso.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Attore;
import it.corso.model.Film;
import jakarta.servlet.http.HttpSession;

public interface AttoreService {
	
	public void registraAttore(String nome, String cognome, LocalDate dataNascita, String password, String email, MultipartFile ritratto, MultipartFile foto );
	List<Attore> getAttori();
	Attore getAttoreById(int id);
	void cancellaAttore(Attore attore);
	List<Film> getFilmByAttoreId(int attoreId);
	public boolean controlloLogin(String email, String password, HttpSession session);
	Attore checkAttore(String email);
	
}
