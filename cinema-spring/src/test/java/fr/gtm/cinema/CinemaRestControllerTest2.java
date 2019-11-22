package fr.gtm.cinema;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CinemaRestControllerTest2 {
	
	@Autowired MockMvc mvc;

	@Test
	void findActeurById() throws Exception {
		 mvc.perform(get("/acteur/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())		   
			      .andExpect(jsonPath("$.id", is(1)));
	}
	

}
