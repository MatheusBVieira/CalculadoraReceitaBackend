package br.com.palharosa.calculadoraDeReceita.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.palharosa.calculadoraDeReceita.model.Embalagem;

public class EmbalagemForm {
	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	private double preco;
	@NotNull
	private int quantidade;

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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Embalagem converter() {
		return new Embalagem(nome, preco, quantidade);
	}

}
