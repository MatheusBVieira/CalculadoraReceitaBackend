package br.com.palharosa.calculadoraDeReceita.model;

import java.util.Map;

public class Receita {

	private Embalagem embalagem;
	private Map<Ingrediente, Double> ingredientes;
	private String nome;
	private int quantidadeProduzida;

	public Embalagem getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(Embalagem embalagem) {
		this.embalagem = embalagem;
	}

	public Map<Ingrediente, Double> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Map<Ingrediente, Double> ingredienteQuantidade) {
		this.ingredientes = ingredienteQuantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadeProduzida() {
		return quantidadeProduzida;
	}

	public void setQuantidadeProduzida(int quantidadeProduzida) {
		this.quantidadeProduzida = quantidadeProduzida;
	}

	public double precoIngredientes() {
		Double valorTotal = 0.0;
		for (Map.Entry<Ingrediente, Double> entrada : ingredientes.entrySet()) {
			Ingrediente ingrediente = entrada.getKey();
			Double quantidadeUsada = entrada.getValue();

			Double precoDoIngredientePelaQuantidade = quantidadeUsada * ingrediente.valorUnidade();
			valorTotal = valorTotal + precoDoIngredientePelaQuantidade;
		}
		return valorTotal;
	}

	public double precoEmbalagem() {
		return embalagem.precoUnidade() * quantidadeProduzida;
	}

	public double precoTotal() {
		return precoIngredientes() + precoEmbalagem();
	}

}
