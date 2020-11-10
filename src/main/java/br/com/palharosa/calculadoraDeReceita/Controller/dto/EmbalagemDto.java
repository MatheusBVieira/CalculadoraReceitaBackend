package br.com.palharosa.calculadoraDeReceita.controller.dto;

import org.springframework.data.domain.Page;

import br.com.palharosa.calculadoraDeReceita.model.Embalagem;

public class EmbalagemDto {

	private Long id;
	private String nome;
	private double preco;
	private int quantidade;

	public EmbalagemDto(Embalagem embalagem) {
		this.id = embalagem.getId();
		this.nome = embalagem.getNome();
		this.preco = embalagem.getPreco();
		this.quantidade = embalagem.getQuantidade();
	}

	public EmbalagemDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public static Page<EmbalagemDto> converter(Page<Embalagem> embalagens) {
		return embalagens.map(EmbalagemDto::new);
	}

}
