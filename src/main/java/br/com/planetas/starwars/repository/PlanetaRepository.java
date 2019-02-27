package br.com.planetas.starwars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.planetas.starwars.model.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {
	@Query("{'nome' : ?0}")
	Planeta findByNamePlaneta(String name);

}
