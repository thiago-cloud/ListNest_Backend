package br.com.appList.listnest.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.appList.listnest.model.ItemLista;
import br.com.appList.listnest.model.Lista;

public interface ListaRepo extends CrudRepository<Lista, Integer>{



}
