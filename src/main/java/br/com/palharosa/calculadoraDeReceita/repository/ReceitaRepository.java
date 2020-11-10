package br.com.palharosa.calculadoraDeReceita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.palharosa.calculadoraDeReceita.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
