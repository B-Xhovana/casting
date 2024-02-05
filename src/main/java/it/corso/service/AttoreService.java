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
	void cancellaAccount(Attore attore);
	List<Film> getFilmografia(int id);
	public boolean controlloLogin(String email, String password, HttpSession session);
	Attore checkAttore(String email);
	public void newRitratto(int id, MultipartFile newRitr,HttpSession session);
	public void newFoto(int id, MultipartFile newFoto,HttpSession session);
	
}
