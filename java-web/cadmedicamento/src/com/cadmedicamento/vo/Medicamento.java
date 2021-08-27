package com.cadmedicamento.vo;

public class Medicamento {
	
	public Medicamento(String nome, Integer tipo, Double valorCusto, Double valorVenda) {
		this.nome = nome;
		this.tipo = tipo;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
	}
	
	public Medicamento() {} 
	
	private Integer id;
	private String nome;
	private Integer tipo;
	private Double valorCusto;
	private Double valorVenda;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	

}
