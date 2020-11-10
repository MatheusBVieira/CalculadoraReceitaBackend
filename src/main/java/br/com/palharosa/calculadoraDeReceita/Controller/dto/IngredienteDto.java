package br.com.palharosa.calculadoraDeReceita.controller.dto;

import org.springframework.data.domain.Page;

import br.com.palharosa.calculadoraDeReceita.model.Ingrediente;

public class IngredienteDto {

	private long id;
	private String nome;
	private double preco;
	private double quantidade;
	private String unidadeMedida;

	public IngredienteDto(Ingrediente ingrediente) {
		this.id = ingrediente.getId();
		this.nome = ingrediente.getNome();
		this.preco = ingrediente.getPreco();
		this.quantidade = ingrediente.getQuantidade();
		this.unidadeMedida = ingrediente.getUnidadeMedida().toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public static Page<IngredienteDto> converter(Page<Ingrediente> ingredientes) {
		return ingredientes.map(IngredienteDto::new);
	}

}
