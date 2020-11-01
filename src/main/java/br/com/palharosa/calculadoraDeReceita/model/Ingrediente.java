package br.com.palharosa.calculadoraDeReceita.model;

public class Ingrediente {

	private String nome;
	private double preco;
	private double quantidade;
	private UnidadeMedida unidadeMedida;

	public Ingrediente() {
	}

	public Ingrediente(String nome, double preco, double quantidade, UnidadeMedida unidadeMedida) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public double valorUnidade() {
		double precoPorUnidade = preco / quantidade;
		return precoPorUnidade;
	}

}
