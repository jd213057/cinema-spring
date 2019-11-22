package fr.gtm.cinema.dto;

import java.io.Serializable;

import fr.gtm.cinema.entities.Acteur;

public class ActeurDTO implements Serializable {
	
	private long id;
	private String civilite;
	private String nom;
	private String prenom;
	
	public ActeurDTO(Acteur acteur) {
		id = acteur.getId();
		civilite = acteur.getCivilite();
		nom = acteur.getNom();
		prenom = acteur.getPrenom();
	}
	
	public ActeurDTO() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Acteur toActeur() {
		Acteur acteur = new Acteur(civilite, nom, prenom);
		acteur.setId(id);
		return acteur;
	}

}
