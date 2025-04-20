package br.com.appList.listnest.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.appList.listnest.model.Produto;
import br.com.appList.listnest.repo.ProdutoRepo;
import br.com.appList.listnest.service.ProdutoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoTests {

    @InjectMocks
    private ProdutoServiceImpl service;

    @Mock
    private ProdutoRepo repo;

    private Produto newProduct;
    private Produto createdProduct;
    private List<Produto> listaDeProdutos;
    private final Integer existingId = 1;
    private final Integer nonExistingId = 100;
    private final String keyword = "bolacha";

	@BeforeEach
	void setup() {
		// O id será gerado automaticamente pelo JPA
		newProduct = new Produto();
		newProduct.setNome("Bolacha");
		
		createdProduct = new Produto();
		createdProduct.setId(1); // Aqui, você pode definir manualmente o id para o produto já criado.
		createdProduct.setNome("Bolacha");
	
		Produto p1 = new Produto();
		p1.setId(2);
		p1.setNome("Bolacha recheada");
	
		Produto p2 = new Produto();
		p2.setId(3);
		p2.setNome("Bolacha água e sal");
	
		listaDeProdutos = List.of(p1, p2);
	
		when(repo.save(newProduct)).thenReturn(createdProduct);
		when(repo.findById(existingId)).thenReturn(Optional.of(createdProduct));
		when(repo.findById(nonExistingId)).thenReturn(Optional.empty());
		when(repo.findAllByNomeContaining(keyword)).thenReturn(listaDeProdutos);
		when(repo.findAllByNomeContaining("Biscoito")).thenReturn(new ArrayList<>());
	}

    @Test
    void deveriaCadastrarProdutoComSucesso() {
        Produto result = service.cadastrarProduto(newProduct);
        assertNotNull(result);
        assertEquals(createdProduct.getId(), result.getId());
        assertEquals("Bolacha", result.getNome());
    }

    @Test
    void deveriaRetornarProdutoPorIdExistente() {
        Produto produto = service.buscarPorId(existingId);
        assertNotNull(produto);
    }

    @Test
    void deveriaRetornarNullParaIdInexistente() {
        Produto produto = service.buscarPorId(nonExistingId);
        assertNull(produto);
    }

    @Test
    void deveriaRetornarListaDeProdutosComPalavraChave() {
        List<Produto> produtos = service.buscarPorPalavraChave(keyword);
        assertAll(
            () -> assertEquals(2, produtos.size()),
            () -> assertEquals("Bolacha recheada", produtos.get(0).getNome()),
            () -> assertEquals("Bolacha água e sal", produtos.get(1).getNome())
        );
    }

    @Test
    void deveriaRetornarListaVaziaQuandoNaoEncontrarProdutos() {
        List<Produto> produtos = service.buscarPorPalavraChave("Biscoito");
        assertTrue(produtos.isEmpty());
    }
}


