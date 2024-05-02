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

import br.com.senac.model.Curso;
import br.com.senac.services.CursoService;

@RestController
@RequestMapping("api/v1/curso")
public class CursoResource {

	@Autowired
	private CursoService cursoService;

	/**
	 * Mètodo para cadastrar um curso
	 *
	 * @param entity
	 * @return
	 */
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Curso cadastrar(@RequestBody Curso entity) {
		return this.cursoService.create(entity);
	}

	/**
	 * Método para consultar curso por identificador
	 *
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", // http://localhost:8080/api/v1/aluno/1
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Curso buscaCursoPorId(@PathVariable("id") Integer id) {
		return this.cursoService.get(id);
	}

	/**
	 * Retorna uma lista de cursos
	 *
	 * @return
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Curso> buscarCursos() {
		return this.cursoService.get();
	}

	public Curso update(@PathVariable Integer id, @RequestBody Curso curso) {
		return this.cursoService.update(id, curso);
	}

	public void delete(@PathVariable Integer id) {
		this.cursoService.delete(id);
	}
}
