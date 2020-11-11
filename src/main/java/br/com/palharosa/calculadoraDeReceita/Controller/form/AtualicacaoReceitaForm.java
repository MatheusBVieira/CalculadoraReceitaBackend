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
import br.com.palharosa.calculadoraDeReceita.repository.ReceitaRepository;

public class AtualicacaoReceitaForm {

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

	public Receita atualizar(Long id, ReceitaRepository receitaRepository, IngredienteRepository ingredienteRepository,
			EmbalagemRepository embalagemRepository) throws IdNotFoundException {
		Receita receita = receitaRepository.getOne(id);
		Map<Double, Ingrediente> ingredientesQuantidade = new LinkedHashMap<>();

		for (Map.Entry<Double, Long> entrada : ingredientes.entrySet()) {
			Long idMap = entrada.getValue();
			Double quantidade = entrada.getKey();
			Optional<Ingrediente> ingrediente = ingredienteRepository.findById(idMap);

			if (ingrediente.isPresent()) {
				ingredientesQuantidade.put(quantidade, ingrediente.get());
			} else {
				throw new IdNotFoundException("Problema Na conversão da receitaForm");
			}
		}
		receita.setIngredientes(ingredientesQuantidade);

		Optional<Embalagem> embalagem = embalagemRepository.findById(idEmbalagem);
		if (embalagem.isPresent()) {
			receita.setEmbalagem(embalagem.get());
		} else {
			throw new IdNotFoundException("Problema na atualização de embalagem");
		}

		receita.setNome(this.nome);
		receita.setQuantidadeProduzida(this.quantidadeProduzida);

		return receita;
	}

}
