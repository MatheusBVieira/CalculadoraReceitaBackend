package br.com.palharosa.calculadoraDeReceita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.palharosa.calculadoraDeReceita.model.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

}
