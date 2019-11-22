package fr.gtm.cinema.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import fr.gtm.cinema.dao.ActeurDAOSPring;
import fr.gtm.cinema.dao.FilmDAOSpring;
import fr.gtm.cinema.dto.ActeurDTO;
import fr.gtm.cinema.dto.FilmDTO;
import fr.gtm.cinema.entities.Acteur;
import fr.gtm.cinema.entities.Film;
import fr.gtm.cinema.entities.Role;
import fr.gtm.cinema.util.MailReceptor;

@RestController
public class CinemaRestController {
	public static final Logger LOG = Logger.getLogger("foo");
	@Autowired private ActeurDAOSPring dao;
	@Autowired private FilmDAOSpring filmDao;
	@Autowired private JavaMailSender mailSender;
	
	@GetMapping(path="/acteur/{id}")
	public ActeurDTO findActeurById(@PathVariable("id") long id) {
		Optional<Acteur> optional = dao.findById(id);
		if(optional.isPresent()) {
			return new ActeurDTO(optional.get());
		}
		
		return null;
		
	}
	
	@PostMapping(path="/acteur/new")
	public String createActeur(@RequestBody ActeurDTO acteurdto) {
		dao.save(acteurdto.toActeur());
		return "ok";
		
	}
	@PostMapping(path="/film/new")
	public String createFilm(@RequestBody FilmDTO filmdto) {
		filmDao.save(filmdto.toFilm());
		return "ok";
		
	}
	
	@GetMapping(path="films/all")
	public List<Film> findAll() {
		List<Film> films = filmDao.findAll();
		return films;
		
	}
	
	@PostMapping("/mail/test")
	public void testMail(@RequestBody MailReceptor mr) {
		try {
		new Thread(()->sendMail(mr)).start();
		} catch(Exception e)	{
			LOG.severe(e.getMessage());
		}
	}
	
	private void sendMail(MailReceptor mr) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(mr.getTo());
		mail.setFrom(mr.getEmail());
		mail.setSubject("Virus");
		mail.setText(mr.getText());
		mailSender.send(mail);
	}
	
	@GetMapping(path="film/moreInfo/{id}") 
	public List<Acteur> findActeurByFilmId(@PathVariable("id") long id){
//		return filmDao.findActeurById(id);
		Film film = filmDao.getFilmWithActorById(id);
		return film.getActeur();
	}
	
//    @PostMapping(path="film/add/actor")
//    public String addActors(@RequestBody Film film) {
//    	 Film filmExists;
//    	   try { filmExists = filmDao.getFilmById(film.getId());}
//    	   catch (Exception e) {
//    		   System.out.println(e.getStackTrace());
//    		boolean notExists = filmDao.getFilmById(film.getId()).equals(null);
//    		
//    		if (notExists) {
//    			System.out.println("not existing in database");
//    			filmDao.save(film);
//    		} 	
//    		filmExists = filmDao.getFilmById(film.getId());
//    	List<Acteur> acteurs = filmExists.getActeur();
//    	List<Acteur> acteursToAdd = film.getActeur();
//    	if (acteurs.size() !=0) return "impossible to add new actors";
//    	else {
//    		for (Acteur acteur : acteursToAdd) {
//    		acteurs.add(acteur);
//    	}
//    	Map<Role, Acteur> roles = new HashMap<Role, Acteur>();	
//    	roles.putAll(acteurs);
//    	filmExists.setRoles(roles);
//    	filmDao.save(filmExists);
//    }}
//    	   return "ok";	
//}
    
    
}
