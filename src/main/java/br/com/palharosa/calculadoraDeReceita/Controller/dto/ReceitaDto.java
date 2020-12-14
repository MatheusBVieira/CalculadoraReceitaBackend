package br.com.palharosa.calculadoraDeReceita.controller.dto;

import java.util.Map;

import org.springframework.data.domain.Page;

import br.com.palharosa.calculadoraDeReceita.model.Embalagem;
import br.com.palharosa.calculadoraDeReceita.model.Ingrediente;
import br.com.palharosa.calculadoraDeReceita.model.Receita;

public class ReceitaDto {

	private long id;
	private Map<Double, Ingrediente> ingredientes;
	private String nome;
	private int quantidadeProduzida;
	private Embalagem embalagem;
	private double precoIngredientes;
	private double precoEmbalagem;
	private double precoTotal;
	private double precoTotalPorUnidade;

	public ReceitaDto(Receita receita) {
		this.id = receita.getId();
		this.nome = receita.getNome();
		this.ingredientes = receita.getIngredientes();
		this.quantidadeProduzida = receita.getQuantidadeProduzida();
		this.precoIngredientes = receita.precoIngredientes();
		this.precoEmbalagem = receita.precoEmbalagem();
		this.precoTotal = receita.precoTotal();
		this.precoTotalPorUnidade = receita.precoTotalPorUnidade();
		this.embalagem = receita.getEmbalagem();
	}

	public Embalagem getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(Embalagem embalagem) {
		this.embalagem = embalagem;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Map<Double, Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Map<Double, Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
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

	public double getPrecoIngredientes() {
		return precoIngredientes;
	}

	public void setPrecoIngredientes(double precoIngredientes) {
		this.precoIngredientes = precoIngredientes;
	}

	public double getPrecoEmbalagem() {
		return precoEmbalagem;
	}

	public void setPrecoEmbalagem(double precoEmbalagem) {
		this.precoEmbalagem = precoEmbalagem;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public double getPrecoTotalPorUnidade() {
		return precoTotalPorUnidade;
	}

	public void setPrecoTotalPorUnidade(double precoTotalPorUnidade) {
		this.precoTotalPorUnidade = precoTotalPorUnidade;
	}

	public static Page<ReceitaDto> converter(Page<Receita> receitas) {
		return receitas.map(ReceitaDto::new);

	}

}
