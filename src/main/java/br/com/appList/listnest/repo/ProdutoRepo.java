package br.com.appList.listnest.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.appList.listnest.model.Produto;

public interface ProdutoRepo extends CrudRepository<Produto, Integer> {
	public List<Produto> findAllByNomeContaining(String palavraChave);//O find faz uma consulta do dado no banco de dados abstraindo o sql graças ao JPA do spring
}
