package br.rafsanches.assti_aula11_named_async_queries.test;

import java.util.List;
import java.util.concurrent.ExecutionException;

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
public class QueryExplicitaTest {
	@Autowired
	private CidadeRepository cidadeRepo;
	
	@Test
	@Order (0)
	public void testQueryExplicita() throws InterruptedException, ExecutionException {
		List<Cidade> cidades1 = cidadeRepo.buscarPeloNome("São Paulo");
		System.out.println("\nPor cidade:");
		cidades1.forEach(System.out::println);
		
		List<Cidade> cidades2 = cidadeRepo.buscarPeloNomeIgnoreCase("são paulo");
		System.out.println("\nPor cidade ignore case:");
		cidades2.forEach(System.out::println);
		
		List<Cidade> cidades3 = cidadeRepo.buscarPorLatELongi(456123.00, 123456.00);
		System.out.println("\nPor Latitude e longitude:");
		cidades3.forEach(System.out::println);
		
		
	}
}
