package fr.gtm.cinema.dto;

import java.io.Serializable;
import java.time.LocalDate;

import fr.gtm.cinema.entities.Acteur;
import fr.gtm.cinema.entities.Film;




public class FilmDTO implements Serializable {
	private long id;
	private String titre;
	private String realisateur;
	private LocalDate dateSortie;
	private int duree;	// durée en minutes;
	private double prixHT;

	
	public FilmDTO() {}
	
	public FilmDTO(fr.gtm.cinema.entities.Film film) {
		id = film.getId();
		titre = film.getTitre();
		realisateur =  film.getRealisateur();
		dateSortie = film.getDateSortie();
		duree = film.getDuree();
		prixHT = film.getPrixHT();

	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public LocalDate getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmDTO other = (FilmDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Film toFilm() {
		Film film = new Film(titre, realisateur, duree, prixHT);
		film.setId(id);
		return film;
	}
	
	
}
