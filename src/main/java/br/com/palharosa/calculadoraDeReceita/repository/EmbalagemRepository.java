package br.com.palharosa.calculadoraDeReceita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.palharosa.calculadoraDeReceita.model.Embalagem;

public interface EmbalagemRepository extends JpaRepository<Embalagem, Long> {

}
