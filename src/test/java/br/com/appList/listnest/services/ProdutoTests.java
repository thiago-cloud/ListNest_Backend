package br.com.appList.listnest.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.appList.listnest.model.Produto;
import br.com.appList.listnest.repo.ProdutoRepo;
import br.com.appList.listnest.service.IProdutoService;
import br.com.appList.listnest.service.ProdutoServiceImpl;

@SpringBootTest
@ActiveProfiles("test")//Utilizando o banco de dados teste h2
public class ProdutoTests {
	
	
	//Mock e uma simulação de algo ou seja uma coisa fake
	
	@InjectMocks//Vai chamar o repositorio mockado
	private ProdutoServiceImpl service;
	
	@Mock//Simulação do repositorio ProdutoRepo
	private ProdutoRepo repo;
	
	private Integer existingId = 1;
	private Integer nonExistingId = 100;
	private String keyword = "bolacha";
	private Produto newProduct;
	private Produto createdProduct;
	private ArrayList<Produto> listaDeVariosProdutos;

	
	//O BeforeEach serve para colocar algo antes da execução dos testes.
	@BeforeEach
	public void setup() throws Exception {
		
		newProduct = new Produto();
		newProduct.setNome("Bolacha");
		
		createdProduct = new Produto();
		createdProduct.setId(1);
		createdProduct.setNome("Bolacha");
		
		listaDeVariosProdutos = new ArrayList<Produto>();
		Produto p1, p2;
		p1 = new Produto();
		p1.setId(2);
		p1.setNome("Bolacha recheada");
		p2 = new Produto();
		p2.setId(3);
		p2.setNome("Bolacha agua e sal");
		
		listaDeVariosProdutos.add(p1);
		listaDeVariosProdutos.add(p2);
		
		Mockito.when(repo.save(newProduct)).thenReturn(createdProduct);
		Mockito.when(repo.findById(existingId)).thenReturn(Optional.of(new Produto()));
		Mockito.when(repo.findById(nonExistingId)).thenReturn(Optional.of(null));
		Mockito.when(repo.findAllByNomeContaining("Biscoito")).thenReturn(new ArrayList<Produto>());
		Mockito.when(repo.findAllByNomeContaining(keyword)).thenReturn(listaDeVariosProdutos);
		
	
	}
	
	
	@Test
	public void deveriaCadastrarProduto() {
		assertEquals(service.cadastrarProduto(newProduct), createdProduct);
	}
	
	@Test
	public void deveriaRetornarPeloId() {
		
	}
	
	@Test
	public void deveriaNaoEncontrarId() {	
	
	}
	
	@Test
	public void deveriaRetornarListaComPalavraChave() {

		
	}	
	
	@Test
	public void deveriaRetornarListaVazia() {
		
	}
	
	

	
	
}
