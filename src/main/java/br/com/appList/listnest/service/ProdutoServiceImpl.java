package br.com.appList.listnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.appList.listnest.model.Produto;
import br.com.appList.listnest.repo.ProdutoRepo;

@Component// Essa anotação permite que esta classe será gerenciada pelo spring boot de forma automática sem a necessidade de instaciar seus objetos de forma manual.
public class ProdutoServiceImpl implements IProdutoService {

	
	@Autowired
	private ProdutoRepo repo;
	
	
	@Override
	public Produto cadastrarProduto(Produto prod) {
		// TODO Auto-generated method stub
		if(prod.getNome() == null || prod.getNome().length() == 0) {
			return null;//Se o nome for uma string vazia ou não for cadastrado nada retorne null
		}
		return repo.save(prod);
	}

	@Override
	public Produto alterarProduto(Produto prod) {
		// TODO Auto-generated method stub
		return repo.save(prod);
	}

	@Override
	public List<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return (List<Produto>) repo.findAll();
	}

	@Override
	public List<Produto> buscarPorPalavraChave(String key) {
		// TODO Auto-generated method stub
		return repo.findAllByNomeContaining(key);
	}

	@Override
	public Produto buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

}
