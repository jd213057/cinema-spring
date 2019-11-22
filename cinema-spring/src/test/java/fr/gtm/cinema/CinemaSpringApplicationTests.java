package fr.gtm.cinema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import fr.gtm.cinema.dao.FilmDAOSpring;
import fr.gtm.cinema.entities.Film;



@SpringBootTest
//@DataJpaTest
class CinemaSpringApplicationTests {
	@Autowired FilmDAOSpring repo;

	@Test
//	@Sql("/dump-cinema-201911201021.sql")
	void getAll() {
		List<Film> films =repo.findAll();
		assertTrue(films.size()>0);
	}
	
	@Test
//	@Sql("/dump-cinema-201911201021.sql")
	void getByTitreStartingWith() {
		List<Film> film =repo.getByTitreStartingWith("Star");
		System.out.println(film);
		assertTrue(film.size()>0);
	}
	
	@Test
//	@Sql("/dump-cinema-201911201021.sql")
	void getFilmById() {
		Film film = repo.getFilmById(1);
		System.out.println(film);
		assertNotNull(film);
	}
	
	@Test
//	@Sql("/dump-cinema-201911201021.sql")
	void getByRealisateurStartingWith() {
		List<Film> film =repo.getByRealisateurStartingWith("George");
		System.out.println(film);
		assertTrue(film.size()>0);
	}
	
	@Test
//	@Sql("/dump-cinema-201911201021.sql")
	void createFilm() {
		List<Film> film1 = repo.findAll();
		for (int i=0; i<=99; i++) {
			Film film = new Film("Star-Wars", "George Lucas", 120, 99.99);
			repo.save(film);
		}
//		repo.save(Civilite.M, "Dimur", "Jonathan");
		
		List<Film> filmTest = repo.getByTitreStartingWith("George");
		System.out.println(filmTest);
		List<Film> film2 = repo.findAll();
		assertNotEquals(film1,film2);
//		assertEquals(100, film2.size());
		
	}
	
	@Test
	void deleteFilm() {
		List<Film> films =repo.findAll();
		for (int i =1; i<=films.size()-1; i++) {
			repo.deleteById(i);
		}
	List<Film> films2 = repo.findAll();
		assertNull(films2);
	}
	
	
	

}
