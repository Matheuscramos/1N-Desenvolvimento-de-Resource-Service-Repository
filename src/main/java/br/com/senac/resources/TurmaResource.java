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

import br.com.senac.model.Turma;
import br.com.senac.services.TurmaService;

@RestController
@RequestMapping("api/v1/turma")
public class TurmaResource {

	@Autowired
	private TurmaService turmaService;

	/**
	 * Mètodo para cadastrar um aluno
	 *
	 * @param entity
	 * @return
	 */

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Turma cadastrar(@RequestBody Turma entity) {
		return turmaService.create(entity);
	}

	/**
	 * Método para consultar aluno por identificador
	 *
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", // http://localhost:8080/api/v1/aluno/1
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Turma buscaTurmaPorId(@PathVariable("id") Integer id) {
		return turmaService.get(id);
	}

	/**
	 * Retorna uma lista de alunos
	 *
	 * @return
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Turma> buscarTurmas() {
		return turmaService.get();
	}

}
