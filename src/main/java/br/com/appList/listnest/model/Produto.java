package br.com.appList.listnest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity//Permite mapear a classe e converter ela na entidade no banco de dados
@Table(name = "tbl_produto")//Nome da tabela no banco de dados
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//O mysql usa campos IDENTITY para poder fazer o auto incremento. O postgres por exemplo usa o SEQUENCE
	@Column(name = "id_produto")//Nome da coluna no banco de dados
	private Integer id;
	
	@Column(name = "nome_produto", length = 70, nullable = false)
	private String nome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
