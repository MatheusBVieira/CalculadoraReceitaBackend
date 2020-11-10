package br.com.palharosa.calculadoraDeReceita.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.palharosa.calculadoraDeReceita.model.Ingrediente;
import br.com.palharosa.calculadoraDeReceita.model.UnidadeMedida;

public class IngredienteForm {

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	private Double preco;

	@NotNull
	private Double quantidade;

	@NotNull
	private UnidadeMedida unidadeMedida;

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

	public Ingrediente converter() {
		return new Ingrediente(nome, preco, quantidade, unidadeMedida);
	}

}
