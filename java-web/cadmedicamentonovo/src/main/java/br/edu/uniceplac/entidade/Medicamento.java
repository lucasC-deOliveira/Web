package br.edu.uniceplac.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.edu.uniceplac.util.AbstractEntity;

@NamedQueries({
	@NamedQuery( name = "Medicamento.find", 
			    query="select m from Medicamento m where upper(m.nome) like upper (:medicamento)" )
  })


@Entity
@Table(name = "medicamento")
public class Medicamento implements AbstractEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmedicamento", unique = true)
	private Integer id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "valorcusto", nullable = false)
	private Double valorCusto;

	@Column(name = "valorvenda", nullable = false)
	private Double valorVenda;

	@Column(name = "idtipo", nullable = false)
	private Integer tipo;

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

	public Double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

}
