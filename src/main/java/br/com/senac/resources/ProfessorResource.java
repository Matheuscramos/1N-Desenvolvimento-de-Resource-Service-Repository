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

import br.com.senac.model.Professor;
import br.com.senac.services.ProfessorService;

@RestController
@RequestMapping("api/v1/professor")
public class ProfessorResource {

	@Autowired
	private ProfessorService professorService;

	/**
	 * Mètodo para cadastrar um professor
	 *
	 * @param entity
	 * @return
	 */
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Professor cadastrar(@RequestBody Professor entity) {
		return professorService.create(entity);
	}

	/**
	 * Método para consultar professor por identificador
	 *
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", // http://localhost:8080/api/v1/aluno/1
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Professor buscaProfessorPorId(@PathVariable("id") Integer id) {
		return professorService.get(id);
	}

	/**
	 * Retorna uma lista de professores
	 *
	 * @return
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Professor> buscarProfessores() {
		return professorService.get();
	}

}
