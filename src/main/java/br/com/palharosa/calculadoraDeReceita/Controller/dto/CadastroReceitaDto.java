package br.com.palharosa.calculadoraDeReceita.controller.dto;

import org.springframework.data.domain.Page;

import br.com.palharosa.calculadoraDeReceita.model.CadastroReceita;
import br.com.palharosa.calculadoraDeReceita.model.Embalagem;
import br.com.palharosa.calculadoraDeReceita.model.Ingrediente;

public class CadastroReceitaDto {
	
	private String label;
	private Long value;
	
	public CadastroReceitaDto(CadastroReceita cadastroReceita) {
		this.label = cadastroReceita.getLabel();
		this.value = cadastroReceita.getValue();
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public static Page<CadastroReceitaDto> converterEmbalagem(Page<Embalagem> embalagens) {
		return embalagens.map(CadastroReceitaDto::new);
	}

	public static Page<CadastroReceitaDto> converterIngrediente(Page<Ingrediente> ingredientes) {
		return ingredientes.map(CadastroReceitaDto::new);
	}
	
	
	
}
