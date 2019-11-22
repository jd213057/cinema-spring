package fr.gtm.cinema.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity
@Table(name="films")
@Access(AccessType.FIELD)
@NamedQuery(name="Film.all",query = "SELECT f FROM Film f")
public class Film implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_film")
	private long id;
	private String titre;
	private String realisateur;
	@Column(name="date_sortie")
	private LocalDate dateSortie;
	@Min(1)
	private int duree;	// durée en minutes;
	@DecimalMin("1.0")
	private double prixHT;
	
	

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="film_acteur",
				joinColumns = @JoinColumn(name="fk_film"),
				inverseJoinColumns = @JoinColumn(name="fk_acteur"))
	private Map<Role, Acteur> roles = new HashMap<Role, Acteur>();

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

	public Map<Role, Acteur> getRoles() {
		return roles;
	}

	public void setRoles(Map<Role, Acteur> roles) {
		this.roles = roles;
	}
	
	public void add(Role role,Acteur acteur) {
		roles.put(role, acteur);
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

   public List<Acteur> getActeur() {
	   return new ArrayList<>(roles.values());
   }

	public Film() {
		super();
	}

	public Film(String titre, @DecimalMin("1.0") double prixHT) {
		super();
		this.titre = titre;
		this.prixHT = prixHT;
	}

	public Film(String titre, @Min(1) int duree, @DecimalMin("1.0") double prixHT) {
		super();
		this.titre = titre;
		this.duree = duree;
		this.prixHT = prixHT;
	}

	public Film(String titre, String realisateur, @Min(1) int duree, @DecimalMin("1.0") double prixHT) {
		super();
		this.titre = titre;
		this.realisateur = realisateur;
		this.duree = duree;
		this.prixHT = prixHT;
	}
	
	

	
}
