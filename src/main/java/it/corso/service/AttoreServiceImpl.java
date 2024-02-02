package it.corso.service;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.corso.dao.AttoreDao;
import it.corso.model.Attore;
import it.corso.model.Film;
import jakarta.servlet.http.HttpSession;

@Service
public class AttoreServiceImpl implements AttoreService {
	
	@Autowired
	private AttoreDao attoreDao;
	
	@Override
	public void registraAttore(String nome, String cognome, LocalDate dataNascita, String password, String email,
			MultipartFile ritratto, MultipartFile foto) {
		Attore attore = new Attore();
		attore.setNome(nome);
		attore.setCognome(cognome);
		attore.setDataNascita(dataNascita);
		attore.setPassword(password);
		attore.setEmail(email);
		if(ritratto!=null && !ritratto.isEmpty()) {
			try {
				// per trascendere dall estensione dell img
				String estensione = ritratto.getContentType(); // questo mi da image/png o jpg che sia
				
				attore.setRitratto("data:"+ estensione + ";base64," + Base64.getEncoder().encodeToString(ritratto.getBytes()));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		if(foto!=null && !foto.isEmpty()) {
			try {
				
				String estensione = foto.getContentType(); 
				
				attore.setFoto("data:"+ estensione + ";base64," + Base64.getEncoder().encodeToString(foto.getBytes()));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		attoreDao.save(attore);
	
		
	}

	@Override
	public boolean controlloLogin(String email, String password, HttpSession session) {
		Attore attore = attoreDao.findByEmailAndPassword(email,password);
		if (email.equalsIgnoreCase(attore.getEmail()) && password.equals(attore.getPassword())) {
			attore.setEmail(email);
			attore.setPassword(password);
			session.setAttribute("attore", attore);
			return true;
		}
		return false;
	}

	@Override
	public Attore checkAttore(String email) {
		Attore attore = attoreDao.findByEmail(email);
		
			return attore;
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
	
	
	@Override
	public void modificaFoto(HttpSession session, MultipartFile ritratto, MultipartFile foto) 
	{
		Attore attore = new Attore();
		
		if(ritratto!=null && !ritratto.isEmpty()) {
			try {
				
				String estensione = ritratto.getContentType(); 
				
				attore.setRitratto("data:"+ estensione + ";base64," + Base64.getEncoder().encodeToString(ritratto.getBytes()));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		if(foto!=null && !foto.isEmpty()) {
			try {
				
				String estensione = foto.getContentType(); 
				
				attore.setFoto("data:"+ estensione + ";base64," + Base64.getEncoder().encodeToString(foto.getBytes()));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		attoreDao.save(attore);
		
	}

}
