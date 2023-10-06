package com.example.microanuncios;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.microanuncios.model.Anuncio;
import com.example.microanuncios.service.AnuncioService;

@SpringBootTest
class MicroanunciosApplicationTests {

	@Autowired
	AnuncioService anuncioService;

	@Test
	void contextLoads() {
		/* 
		Anuncio anuncio = anuncioService.getAnuncioById(1);
		assumeTrue (anuncio != null, anuncio.toString());
		*/
	}

}
