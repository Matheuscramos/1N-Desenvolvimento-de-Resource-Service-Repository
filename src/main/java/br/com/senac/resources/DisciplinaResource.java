package br.com.senac.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.model.Disciplina;
import br.com.senac.services.DisciplinaService;

@RestController
@RequestMapping("api/v1/disciplina")
public class DisciplinaResource {

	@Autowired
	private DisciplinaService disciplinaService;

	/**
	 * Mètodo para cadastrar uma disciplinas
	 *
	 * @param entity
	 * @return
	 */
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Disciplina cadastrar(@RequestBody Disciplina entity) {
		return disciplinaService.create(entity);
	}

	/**
	 * Método para consultar disciplina por identificador
	 *
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", // http://localhost:8080/api/v1/aluno/1
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Disciplina buscaCursoPorId(@PathVariable("id") Integer id) {
		return disciplinaService.get(id);
	}

	/**
	 * Retorna uma lista de disciplinas
	 *
	 * @return
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Disciplina> buscarCursos() {
		return disciplinaService.get();
	}

}
