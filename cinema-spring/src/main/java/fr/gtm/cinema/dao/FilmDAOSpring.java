package fr.gtm.cinema.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.gtm.cinema.entities.Acteur;
import fr.gtm.cinema.entities.Film;
import fr.gtm.cinema.entities.Role;


@Repository
public interface FilmDAOSpring extends JpaRepository<Film, Long>{
	
	

	List<Film> getByTitreStartingWith(String titre);
	List<Film> getByRealisateurStartingWith(String Realisateur);
	Film getFilmById (long id);
	void deleteById(long id);
	
	default Map<Role,Acteur> findActeurById(long id) {
		Film film = getFilmById(id);
		return film.getRoles();
	}
	@Query("SELECT f from Film f JOIN FETCH f.roles WHERE f.id=?1")
	Film getFilmWithActorById(long id);
	

}
