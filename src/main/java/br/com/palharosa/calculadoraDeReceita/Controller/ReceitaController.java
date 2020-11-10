package br.com.palharosa.calculadoraDeReceita.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.palharosa.calculadoraDeReceita.controller.dto.ReceitaDto;
import br.com.palharosa.calculadoraDeReceita.controller.form.ReceitaForm;
import br.com.palharosa.calculadoraDeReceita.exception.IdNotFoundException;
import br.com.palharosa.calculadoraDeReceita.model.Receita;
import br.com.palharosa.calculadoraDeReceita.repository.EmbalagemRepository;
import br.com.palharosa.calculadoraDeReceita.repository.IngredienteRepository;
import br.com.palharosa.calculadoraDeReceita.repository.ReceitaRepository;

@RestController
@RequestMapping("receita")
public class ReceitaController {

	@Autowired
	private ReceitaRepository receitaRepository;

	@Autowired
	private EmbalagemRepository embalagemRepository;

	@Autowired
	private IngredienteRepository ingredienteRepository;

	@GetMapping
	public Page<ReceitaDto> lista(
			@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		Page<Receita> receitas = receitaRepository.findAll(paginacao);
		return ReceitaDto.converter(receitas);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ReceitaDto> inserir(@RequestBody @Valid ReceitaForm form, UriComponentsBuilder uriBuilder)
			throws IdNotFoundException {
		Receita receita = form.converter(embalagemRepository, ingredienteRepository);
		receitaRepository.save(receita);

		URI uri = uriBuilder.path("/receita/{id}").buildAndExpand(receita.getId()).toUri();
		return ResponseEntity.created(uri).body(new ReceitaDto(receita));
	}

}
