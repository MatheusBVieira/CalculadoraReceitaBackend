package br.com.palharosa.calculadoraDeReceita.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.palharosa.calculadoraDeReceita.controller.dto.IngredienteDto;
import br.com.palharosa.calculadoraDeReceita.controller.form.AtualizacaoIngredienteForm;
import br.com.palharosa.calculadoraDeReceita.controller.form.IngredienteForm;
import br.com.palharosa.calculadoraDeReceita.model.Ingrediente;
import br.com.palharosa.calculadoraDeReceita.repository.IngredienteRepository;

@RestController
@RequestMapping("ingrediente")
public class IngredienteController {

	@Autowired
	private IngredienteRepository ingredienteRepository;

	@GetMapping
	public Page<IngredienteDto> lista(
			@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		Page<Ingrediente> ingredientes = ingredienteRepository.findAll(paginacao);
		return IngredienteDto.converter(ingredientes);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<IngredienteDto> inserir(@RequestBody @Valid IngredienteForm form,
			UriComponentsBuilder uriBuilder) {
		Ingrediente ingrediente = form.converter();
		ingredienteRepository.save(ingrediente);

		URI uri = uriBuilder.path("/ingrediente/{id}").buildAndExpand(ingrediente.getId()).toUri();
		return ResponseEntity.created(uri).body(new IngredienteDto(ingrediente));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<IngredienteDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoIngredienteForm form) {

		Optional<Ingrediente> optional = ingredienteRepository.findById(id);
		if (optional.isPresent()) {
			Ingrediente ingrediente = form.atualizar(id, ingredienteRepository);
			return ResponseEntity.ok(new IngredienteDto(ingrediente));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Ingrediente> optional = ingredienteRepository.findById(id);
		if (optional.isPresent()) {
			ingredienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
