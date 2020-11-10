package br.com.palharosa.calculadoraDeReceita.controller.form;

import br.com.palharosa.calculadoraDeReceita.model.Ingrediente;
import br.com.palharosa.calculadoraDeReceita.repository.IngredienteRepository;

public class AtualizacaoIngredienteForm {

	private String nome;
	private double preco;
	private double quantidade;

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

	public Ingrediente atualizar(Long id, IngredienteRepository ingredienteRepository) {
		Ingrediente ingrediente = ingredienteRepository.getOne(id);

		ingrediente.setNome(this.nome);
		ingrediente.setPreco(preco);
		ingrediente.setQuantidade(quantidade);

		return ingrediente;
	}

}
