package br.com.planetas.starwars.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="planeta")

public class Planeta {
	
	@Id
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private Integer QuantidadeAparicoesFilme;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public Integer getQuantidadeAparicoesFilme() {
		return QuantidadeAparicoesFilme;
	}
	public void setQuantidadeAparicoesFilme(Integer quantidadeAparicoesFilme) {
		QuantidadeAparicoesFilme = quantidadeAparicoesFilme;
	}
	@Override
	public String toString() {
		return "Planeta [id=" + id + ", nome=" + nome + ", clima=" + clima + ", terreno=" + terreno
				+ ", QuantidadeAparicoesFilme=" + QuantidadeAparicoesFilme + "]";
	}
		
}
