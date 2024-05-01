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

import br.com.senac.model.Aluno;
import br.com.senac.model.AlunoCurso;
import br.com.senac.services.AlunoService;

@RestController
@RequestMapping("api/v1/aluno")
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;

	/**
	 * Mètodo para cadastrar um aluno
	 *
	 * @param entity
	 * @return
	 */
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Aluno cadastrar(@RequestBody Aluno entity) {
		return alunoService.create(entity);
	}

	/**
	 * Método para consultar aluno por identificador
	 *
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}", // http://localhost:8080/api/v1/aluno/1
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Aluno buscaAlunoPorId(@PathVariable("id") Integer id) {
		return alunoService.get(id);
	}

	/**
	 * Retorna uma lista de alunos
	 *
	 * @return
	 */
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Aluno> buscarAlunos() {
		return alunoService.get();
	}

	@PostMapping(value = "matricula-curso/{idAluno}/{idCurso}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Aluno matricularCurso(@PathVariable("idAluno") Integer idAluno, @PathVariable("idCurso") Integer idCurso)
			throws Exception {
		return alunoService.matriculaCurso(idAluno, idCurso);
	}
}
