package br.com.palharosa.calculadoraDeReceita.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class TesteReceita {
	public static void main(String[] args) {
		Receita receita = new Receita();

		Ingrediente leiteCondensado = new Ingrediente("Leite Condensado", 5, 395, UnidadeMedida.GRAMAS);
		Ingrediente cremeDeLeite = new Ingrediente("Creme de leite", 4, 300, UnidadeMedida.GRAMAS);
		Ingrediente farinhaDeTrigo = new Ingrediente("Farinha de trigo", 3.29, 1000, UnidadeMedida.GRAMAS);
		Ingrediente qualy = new Ingrediente("Qualy", 4.39, 500, UnidadeMedida.GRAMAS);
		Ingrediente chocolateEmPo = new Ingrediente("Chocolate em pó", 9.9, 1000, UnidadeMedida.GRAMAS);
		Ingrediente granulado = new Ingrediente("Granulado", 3.49, 150, UnidadeMedida.GRAMAS);

		Map<Ingrediente, Double> ingredienteQuantidade = new LinkedHashMap<Ingrediente, Double>();

		ingredienteQuantidade.put(leiteCondensado, 395.0);
		ingredienteQuantidade.put(cremeDeLeite, (double) 300);
		ingredienteQuantidade.put(farinhaDeTrigo, (double) 30);
		ingredienteQuantidade.put(qualy, (double) 20);
		ingredienteQuantidade.put(chocolateEmPo, (double) 80);
		ingredienteQuantidade.put(granulado, (double) 150);

		Embalagem embalagem = new Embalagem("Embalagem rosqueavel plastico", 195, 150);

		receita.setNome("Receita teste");
		receita.setEmbalagem(embalagem);
//		receita.setIngredientes(ingredienteQuantidade);
		receita.setQuantidadeProduzida(30);

		System.out.println(receita.precoTotal());

//		for (Map.Entry<Ingrediente, BigDecimal> entrada : ingredienteQuantidade.entrySet()) {
//			Ingrediente ingrediente = entrada.getKey();
//			BigDecimal valor = entrada.getValue();
//			System.out.println(ingrediente.getNome() + " " + valor);
//		}

	}
}
