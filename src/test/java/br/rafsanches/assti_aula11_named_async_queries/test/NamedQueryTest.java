package br.rafsanches.assti_aula11_named_async_queries.test;

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
public class NamedQueryTest {
	@Autowired
	private CidadeRepository cidadeRepo;
	
	
	@Test
	@Order (0)
	public void nomeTest() {
		Cidade c = cidadeRepo.buscaPeloNome("São Paulo");
		System.out.println("\nNamed por Nome: " + c);
	}
	
	@Test
	@Order (1)
	public void nomeIgnoreCaseTest() {
		Cidade c = cidadeRepo.buscaPeloNomeIgnoreCase("são paulo");
		System.out.println("\nNamed por Nome Ignore Case: " + c);
	}
	
	@Test
	@Order (2)
	public void latLongiTest() {
		Cidade c = cidadeRepo.buscaPorLatELongi(789456.00, 456789.00);
		System.out.println("\nNamed por Lat e Long> " + c);
	}
	
}
