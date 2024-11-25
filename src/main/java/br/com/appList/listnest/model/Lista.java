package br.com.appList.listnest.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_lista")
public class Lista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lista")
	private Integer id;
	
	@Column(name = "date_criacao", nullable = false)
	private LocalDate data;//Aqui porque não o java.util.Date porque apartir do java 8 o java.util.Date foi substituido pelo java.time.LocalDate
	
	@Column(name = "nome_mercado", length = 50)
	private String nomeMercado;
	
	public List<ItemLista> getItens() {
		return itens;
	}

	public void setItens(List<ItemLista> itens) {
		this.itens = itens;
	}

	@Column(name = "valor_total")
	private Double valorTotal;
	
	@Column(name = "status")
	private Integer status;
	
	// Na minha lista preciso declara que terei um conjunto de itens por isso temos o list
	@OneToMany(mappedBy = "lista", cascade = CascadeType.ALL) //De lista para itens e one to many, agora a chave estrangeira que referencia a lista é "lista" ela estar em ItemLista
	private List<ItemLista> itens;//O cascade seguinifica que quando eu removo uma lista os respectivos itens dela também é removido
	
	//Getter e Setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getNomeMercado() {
		return nomeMercado;
	}

	public void setNomeMercado(String nomeMercado) {
		this.nomeMercado = nomeMercado;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
