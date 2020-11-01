package br.com.palharosa.calculadoraDeReceita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class CalculadoraDeReceitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraDeReceitaApplication.class, args);
	}

}
