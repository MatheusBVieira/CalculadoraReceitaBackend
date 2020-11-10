package br.com.palharosa.calculadoraDeReceita.controller.form;

import br.com.palharosa.calculadoraDeReceita.model.Embalagem;
import br.com.palharosa.calculadoraDeReceita.repository.EmbalagemRepository;

public class AtualizacaoEmbalagemForm {
	private String nome;
	private double preco;
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

	public Embalagem atualizar(Long id, EmbalagemRepository embalagemRepository) {
		Embalagem embalagem = embalagemRepository.getOne(id);

		embalagem.setNome(nome);
		embalagem.setPreco(preco);
		embalagem.setQuantidade(quantidade);

		return embalagem;

	}

}
