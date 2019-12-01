package br.rafsanches.assti_aula11_named_async_queries.test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import aula11.named.async.queries.model.beans.Cidade;
import aula11.named.async.queries.model.repository.CidadeRepository;

@SpringBootTest
@RunWith (SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AsyncQueryTest {
	@Autowired
	private CidadeRepository cidadeRepo;
	
	@Test
	@Order (0)
	public void testFindAllAsync () throws InterruptedException, ExecutionException {
		Future <List <Cidade> > futureCidades = cidadeRepo.queryByNome("São Caetano");
		System.out.println("\nCódigo aqui");
		System.out.println("Mais Código");
		
		// pego o resultado
		//a chamada pode bloquear ou nao
		List<Cidade> cidades;
		try {
			cidades = futureCidades.get(1, TimeUnit.MINUTES);
			System.out.println("\nLista de cidades:");
			for (Cidade cidade : cidades) {
				System.out.println(cidade);
			}
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Order (1)
	public void testFindOneByNomeAsync () throws InterruptedException, ExecutionException {
		Future <Cidade> futureCidade = cidadeRepo.findByNome("São Paulo");
		System.out.println("\nCódigo aqui");
		System.out.println("Mais Código");
		
		// pego o resultado
		//a chamada pode bloquear ou nao
		Cidade cidade;
		try {
			cidade = futureCidade.get(1, TimeUnit.MINUTES);
			System.out.println("\nCidade São Paulo:");
			System.out.println(cidade);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Order (2)
	public void testFindOneNomeIgnoreCaseAsync () throws InterruptedException, ExecutionException {
		Future <Cidade> futureCidade = cidadeRepo.findByNomeIgnoreCase("são paulo");
		System.out.println("\nCódigo aqui");
		System.out.println("Mais Código");
		
		// pego o resultado
		//a chamada pode bloquear ou nao
		Cidade cidade;
		try {
			cidade = futureCidade.get(1, TimeUnit.MINUTES);
			System.out.println("\nCidade são paulo:");
			System.out.println(cidade);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Order (3)
	public void testFindByLatLonAsync () throws InterruptedException, ExecutionException {
		Future <Cidade> futureCidade = cidadeRepo.findByLatitudeAndLongitude(456123.00, 123456.00);
		System.out.println("\nCódigo aqui");
		System.out.println("Mais Código");
		
		// pego o resultado
		//a chamada pode bloquear ou nao
		Cidade cidade;
		try {
			cidade = futureCidade.get(1, TimeUnit.MINUTES);
			System.out.println("\nPor Latitude e Longitude:");
			System.out.println(cidade + "\n");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
}
