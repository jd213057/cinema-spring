package fr.gtm.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.cinema.entities.Acteur;
import fr.gtm.cinema.entities.Film;
@Repository
public interface ActeurDAOSPring extends JpaRepository<Acteur, Long>{

}
