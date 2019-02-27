package br.com.planetas.starwars.controller;

import org.springframework.web.client.RestTemplate;

public class PlanetaAparicoesController {
	final String uri= "https://swapi.co/api/planets/?search=Alderaan";
	RestTemplate restTemplate = new RestTemplate();
	

}
