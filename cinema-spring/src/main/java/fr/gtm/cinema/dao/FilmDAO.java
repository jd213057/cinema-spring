package fr.gtm.cinema.dao;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.cinema.entities.Film;

@javax.inject.Singleton
public class FilmDAO extends AbstractDAO<fr.gtm.cinema.entities.Film, Long> {
	@PersistenceContext(name="cinema") private EntityManager em;

	public FilmDAO() {
		super(fr.gtm.cinema.entities.Film.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Film> getAllFilms() {
		return em.createNamedQuery("Film.all", Film.class).getResultList();
	}

}
