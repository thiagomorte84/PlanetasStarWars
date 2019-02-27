package br.com.planetas.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.planetas.starwars.exception.ResourceNotFoundException;
import br.com.planetas.starwars.model.Planeta;
import br.com.planetas.starwars.repository.PlanetaRepository;

@RestController
@RequestMapping("/api/planetasstarwars")
public class PlanetaController {

	@Autowired
	private PlanetaRepository planetaRepository;

	@PostMapping
	public Planeta adicionarPlaneta(@Validated @RequestBody Planeta planeta) {
		return planetaRepository.save(planeta);
	}

	@GetMapping
	public List<Planeta> listarPlanetas() {
		return planetaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Planeta buscaPorId(@PathVariable(value = "id") String planetaId) {
		return planetaRepository.findById(planetaId)
				.orElseThrow(() -> new ResourceNotFoundException("Planeta", "id", planetaId));
	}

	@GetMapping("/nome/{nome}")
	public Planeta buscaPorNome(@PathVariable(value = "nome") String nome) {

		return planetaRepository.findByNamePlaneta(nome);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerPlaneta(@PathVariable(value = "id") String planetaId) {
		Planeta planeta = planetaRepository.findById(planetaId)
				.orElseThrow(() -> new ResourceNotFoundException("Planeta", "id", planetaId));
		planetaRepository.delete(planeta);
		return ResponseEntity.ok().build();
	}
}
