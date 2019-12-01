package br.rafsanches.assti_aula11_named_async_queries;

import java.util.List;
import java.util.Optional;

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
public class CidadeTest {
	@Autowired
	private CidadeRepository cidadeRepo;

	@Test
	@Order(0)
	public void testInsertCidade() {
		Cidade c = new Cidade();
		c.setNome("São Paulo");
		c.setLatitude(123456.00);
		c.setLongitude(654321.00);
		c = cidadeRepo.save(c);
		
		Cidade c2 = new Cidade();
		c2.setNome("Teste");
		c2.setLatitude(111222.00);
		c2.setLongitude(333444.00);
		c2 = cidadeRepo.save(c2);
		System.out.println("\n Id inserido: " + c.getId() +
							"\n Id inserido: " + c2.getId() + "id \n");
	}

	@Test
	@Order(1)
	public void testBuscaPorId() {
		Optional<Cidade> c = cidadeRepo.findById(2L);
		System.out.println("\n Por id: " + c.get() + "id \n");
	}

	@Test
	@Order(2)
	public void testBuscaTodos() {
		List<Cidade> cidades = cidadeRepo.findAll();
		System.out.println("\n Todos: " + cidades + "todos \n");
	}

	@Test
	@Order(3)
	public void testDeletePorId() {
		Cidade c = new Cidade();
		c.setId(4L);
		cidadeRepo.delete(c);
	}

	@Test
	@Order(4)
	public void testQuantidade() {
		System.out.println("\n Qtde: " + cidadeRepo.count() + "qtde \n");
	}
	
	
	
	
	/*
	@Test
	public void testBuscaPorNome() {

	}

	@Test
	public void testBuscaPorLatELong() {

	}

	@Test
	public void testBuscaPorNomeIgnoreCaps() {

	}
	*/
}
