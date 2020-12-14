package br.com.palharosa.calculadoraDeReceita.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;

@Entity
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "embalagem_id")
	private Embalagem embalagem;

	@ManyToMany(cascade = CascadeType.ALL)
	@MapKeyColumn(name = "quantidade")
	@JoinTable(name = "receita_ingrediente", joinColumns = @JoinColumn(name = "receita_id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
	private Map<Double, Ingrediente> ingredientes;

	private String nome;
	private int quantidadeProduzida;

	public Receita(Embalagem embalagem, Map<Double, Ingrediente> ingredientes, String nome, int quantidadeProduzida) {
		super();
		this.embalagem = embalagem;
		this.ingredientes = ingredientes;
		this.nome = nome;
		this.quantidadeProduzida = quantidadeProduzida;
	}

	public Receita() {
		// TODO Auto-generated constructor stub
	}

	public Embalagem getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(Embalagem embalagem) {
		this.embalagem = embalagem;
	}

	public Map<Double, Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Map<Double, Ingrediente> ingredienteQuantidade) {
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
		for (Map.Entry<Double, Ingrediente> entrada : ingredientes.entrySet()) {
			Ingrediente ingrediente = entrada.getValue();
			Double quantidadeUsada = entrada.getKey();

			Double precoDoIngredientePelaQuantidade = quantidadeUsada * ingrediente.valorUnidade();
			valorTotal = valorTotal + precoDoIngredientePelaQuantidade;
		}
		return valorTotal * quantidadeProduzida;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double precoEmbalagem() {
		return embalagem.precoUnidade() * quantidadeProduzida;
	}

	public double precoTotal() {
		return precoIngredientes() + precoEmbalagem();
	}
	
	public double precoTotalPorUnidade() {
		return precoTotal() / quantidadeProduzida;
	}

}
