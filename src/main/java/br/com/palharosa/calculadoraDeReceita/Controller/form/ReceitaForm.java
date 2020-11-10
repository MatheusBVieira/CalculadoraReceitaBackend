package br.com.palharosa.calculadoraDeReceita.controller.form;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import br.com.palharosa.calculadoraDeReceita.exception.IdNotFoundException;
import br.com.palharosa.calculadoraDeReceita.model.Embalagem;
import br.com.palharosa.calculadoraDeReceita.model.Ingrediente;
import br.com.palharosa.calculadoraDeReceita.model.Receita;
import br.com.palharosa.calculadoraDeReceita.repository.EmbalagemRepository;
import br.com.palharosa.calculadoraDeReceita.repository.IngredienteRepository;

public class ReceitaForm {

	private long idEmbalagem;
	private Map<Double, Long> ingredientes;
	private String nome;
	private int quantidadeProduzida;

	public long getIdEmbalagem() {
		return idEmbalagem;
	}

	public void setIdEmbalagem(long idEmbalagem) {
		this.idEmbalagem = idEmbalagem;
	}

	public Map<Double, Long> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Map<Double, Long> ingredientes) {
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

	public Receita converter(EmbalagemRepository embalagemRepository, IngredienteRepository ingredienteRepository)
			throws IdNotFoundException {
		Map<Double, Ingrediente> ingredientesQuantidade = new LinkedHashMap<>();
		for (Map.Entry<Double, Long> entrada : ingredientes.entrySet()) {
			Long id = entrada.getValue();
			Double quantidade = entrada.getKey();
			Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);

			if (ingrediente.isPresent()) {
				ingredientesQuantidade.put(quantidade, ingrediente.get());
			} else {
				throw new IdNotFoundException("Problema Na conversão da receitaForm");
			}
		}
		Optional<Embalagem> embalagem = embalagemRepository.findById(idEmbalagem);
		if (embalagem.isPresent()) {
			return new Receita(embalagem.get(), ingredientesQuantidade, nome, quantidadeProduzida);
		}

		throw new IdNotFoundException("Problema Na conversão da receitaForm");

	}
}
