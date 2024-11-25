package br.com.appList.listnest.service;

import br.com.appList.listnest.model.ItemLista;

public interface IItemListaService {

	public ItemLista inserirItem(ItemLista novo);
	public ItemLista alterarItem(ItemLista item);
	public void removerItem(Integer numSeq);

}
