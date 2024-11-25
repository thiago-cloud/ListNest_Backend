package br.com.appList.listnest.service;

import java.util.List;

import br.com.appList.listnest.model.Produto;

public interface IProdutoService {
	
	public Produto cadastrarProduto(Produto prod);
	//public Produto alterarProduto(Produto prod);
	public List<Produto> listarTodos();
	public List<Produto> buscarPorPalavraChave(String key);
	public Produto buscarPorId(Integer id);
	Produto alterarProduto(Produto prod);

}
