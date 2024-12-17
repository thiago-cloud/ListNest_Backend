package br.com.appList.listnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.appList.listnest.model.Produto;
import br.com.appList.listnest.service.IProdutoService;

@RestController
//@CrossOrigin("*")
public class ProdutoController {
	
	//O responseEntity é uma classe do spring que representa  toda  a resposta HTTP, incluindo o corpo da resposta o status e os cabeçalhos ele é util quando se precisar personalizar status http ou adicionar cabeçalhos especificos a resposta

	@Autowired
	private IProdutoService service;
	
	@PostMapping("/produtos")//O padrão do requestMapping será sempre json caso não especifique e a forma mais caso fosse xml seria assim: @PostMapping(consumes = "application/xml", produces = "application/xml")
	public ResponseEntity<Produto> cadastrarNovo(@RequestBody Produto novo){
		Produto prod = service.cadastrarProduto(novo);
		if(prod != null) {
			return ResponseEntity.status(201).body(prod); //Retorno 201 e tenho o produto sendo cadastrado
		}
		return ResponseEntity.badRequest().build();
	}
	
	//O requestParam é uma query string esse Post vai buscar pela palavra chave no banco de dados
	//produtos/search?k=nomeProduto
	@GetMapping("/produtos/search")
	public ResponseEntity<List<Produto>> recuperarPorPalavraChave(@RequestParam(name="k") String keyword){
		return ResponseEntity.ok(service.buscarPorPalavraChave(keyword));
	}
	
	//Mostrar um produto através do id
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> recuperarPorId(@PathVariable Integer id){
		Produto res = service.buscarPorId(id);
		
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	//Listar todo os produtos
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> recuperarTodos(){
		return ResponseEntity.ok(service.listarTodos());
	}
}
