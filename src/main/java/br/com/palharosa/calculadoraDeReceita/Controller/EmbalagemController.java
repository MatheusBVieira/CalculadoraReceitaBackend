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

import br.com.palharosa.calculadoraDeReceita.controller.dto.CadastroReceitaDto;
import br.com.palharosa.calculadoraDeReceita.controller.dto.EmbalagemDto;
import br.com.palharosa.calculadoraDeReceita.controller.form.AtualizacaoEmbalagemForm;
import br.com.palharosa.calculadoraDeReceita.controller.form.EmbalagemForm;
import br.com.palharosa.calculadoraDeReceita.model.Embalagem;
import br.com.palharosa.calculadoraDeReceita.repository.EmbalagemRepository;

@RestController
@RequestMapping("embalagem")
public class EmbalagemController {

	@Autowired
	private EmbalagemRepository embalagemRepository;

	@GetMapping
	public Page<EmbalagemDto> lista(
			@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 500) Pageable paginacao) {

		Page<Embalagem> embalagens = embalagemRepository.findAll(paginacao);
		return EmbalagemDto.converter(embalagens);
	}
	
	@GetMapping("/receita")
	public Page<CadastroReceitaDto> listaReceita(
			@PageableDefault(sort = "nome", direction = Direction.DESC, page = 0, size = 500) Pageable paginacao) {
		
		Page<Embalagem> embalagens = embalagemRepository.findAll(paginacao);
		return CadastroReceitaDto.converterEmbalagem(embalagens);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<EmbalagemDto> inserir(@RequestBody @Valid EmbalagemForm form,
			UriComponentsBuilder uriBuilder) {
		Embalagem embalagem = form.converter();
		embalagemRepository.save(embalagem);

		URI uri = uriBuilder.path("/embalagem/{id}").buildAndExpand(embalagem.getId()).toUri();
		return ResponseEntity.created(uri).body(new EmbalagemDto(embalagem));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EmbalagemDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoEmbalagemForm form) {

		Optional<Embalagem> optional = embalagemRepository.findById(id);
		if (optional.isPresent()) {
			Embalagem embalagem = form.atualizar(id, embalagemRepository);
			return ResponseEntity.ok(new EmbalagemDto(embalagem));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Embalagem> optional = embalagemRepository.findById(id);
		if (optional.isPresent()) {
			embalagemRepository.deleteById(id);
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.notFound().build();
	}

}
