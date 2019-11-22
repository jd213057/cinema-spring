package fr.gtm.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;




@SpringBootApplication
public class CinemaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaSpringApplication.class, args);
	}

}
