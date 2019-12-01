package aula11.named.async.queries.model.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import aula11.named.async.queries.model.beans.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	/*
	// Síncrono	
	public Cidade findByNome (String nome);
	
	public Cidade findByNomeIgnoreCase(String nome);
	
	public Cidade findByLatitudeAndLongitude (Double latitude, Double longitude);
	
	public Cidade getByNome (String nome);
	
	public int countByNome (String nome);
	
	@Transactional
	public long deleteByNome (String nome);
	
	//public List<Cidade> queryByNome (String nome);
	*/
	
	// Assincrono
	@Async
	public Future <Cidade> findByNome (String nome);
	@Async
	public Future <Cidade> findByNomeIgnoreCase(String nome);
	@Async
	public Future <Cidade> findByLatitudeAndLongitude (Double latitude, Double longitude);
	
	@Async
	public Future < List<Cidade> > queryByNome (String nome);
	
	
	
	// QUERY EXLPLICITA
	@Query ("SELECT c FROM Cidade c WHERE c.nome = ?1")
	public List <Cidade> buscarPeloNome (String nome);
		
	@Query ("SELECT c FROM Cidade c WHERE LOWER(nome) = LOWER(?1)")
	public List <Cidade> buscarPeloNomeIgnoreCase (String nome);
	
	@Query ("SELECT c FROM Cidade c WHERE latitude = :latitude AND longitude = :longitude")
	public List<Cidade> buscarPorLatELongi (Double latitude, Double longitude);
	
	
	
	@Query ("SELECT c FROM Cidade c WHERE c.nome LIKE ?1%")
	public List <Cidade> buscarPorLetraInicialDoNome (String letra);
	
	
	// NAMED QUERY
	public Cidade buscaPeloNome (@Param ("nome") String nome);
	
	public Cidade buscaPeloNomeIgnoreCase (@Param ("nome") String nome);
	
	public Cidade buscaPorLatELongi (@Param ("latitude") Double latitude,
										@Param ("longitude") Double longitude);

}
