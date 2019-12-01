package br.rafsanches.assti_aula11_named_async_queries;

import java.util.List;

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


@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CidadeQueryTest {
	@Autowired
	private CidadeRepository cidadeRepo;
	/*
	@Test
	@Order (0)
	public void findOneTestNome() {
		Cidade c = cidadeRepo.findByNome("São Paulo");
		System.out.println("\n Cidade: " + c);
	}
	
	@Test
	@Order (1)
	public void findOneTestNomeIgnoreCase() {
		Cidade c = cidadeRepo.findByNomeIgnoreCase("são paulo");
		System.out.println("\n Cidade Ignore Case: " + c);
	}
	
	@Test
	@Order (2)
	public void findOneTestLatLon() {
		Cidade c = cidadeRepo.findByLatitudeAndLongitude(123456.00, 654321.00);
		System.out.println("\n Por Lat e Long: " + c);
	}
	
	@Test
	@Order (3)
	public void findManyTestNome() {
		List<Cidade> cidades = cidadeRepo.queryByNome("São Caetano");
		System.out.println("\n Lista:" + cidades);
	}
	*/
}
