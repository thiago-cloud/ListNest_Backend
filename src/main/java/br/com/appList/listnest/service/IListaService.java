package br.com.appList.listnest.service;

import java.util.List;

import br.com.appList.listnest.model.ItemLista;
import br.com.appList.listnest.model.Lista;

public interface IListaService {
	public Lista criarNovaLista(Lista nova);
	public void removerLista(Integer id);
	public Lista fecharLista(Integer id);
	public Lista buscarPeloId(Integer id);
	public List<Lista> buscarTodas();
	
}
