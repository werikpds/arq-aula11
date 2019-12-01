package aula11.named.async.queries.model.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name = "tb_cidade")
@NamedQueries ({
	@NamedQuery (name = "Cidade.buscaPeloNome",
					query = "SELECT c FROM Cidade c WHERE c.nome = ?1"),
	@NamedQuery (name = "Cidade.buscaPeloNomeIgnoreCase",
					query = "SELECT c FROM Cidade c WHERE LOWER(nome) = LOWER(?1)"),
	@NamedQuery (name = "Cidade.buscaPorLatELongi",
				query = "SELECT c FROM Cidade c WHERE latitude = :latitude AND longitude = :longitude")
})
public class Cidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double latitude;
	private Double longitude;
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
}
