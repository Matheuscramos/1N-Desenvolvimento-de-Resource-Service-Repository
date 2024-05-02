package br.com.senac.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.interfaces.IService;
import br.com.senac.model.Aluno;
import br.com.senac.model.Curso;
import br.com.senac.repositories.AlunoRepository;

@Service
public class AlunoService implements IService<Aluno, Integer> {

	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private CursoService cursoService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Aluno create(Aluno entity) {
		return this.alunoRepository.save(entity);
	}

	@Override
	public Aluno get(Integer id) {
		Optional<Aluno> alunoEncontrado = alunoRepository.findById(id);
		if (alunoEncontrado.isPresent()) {
			return alunoEncontrado.get();
		} else {
			return new Aluno();
		}
	}

	@Override
	public List<Aluno> get() {
		return this.alunoRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Aluno update(Integer id, Aluno entity) {
		Aluno alunoEncontrado = this.get(id);
		if (alunoEncontrado.getId() != 0 || alunoEncontrado.getId() != null) {
			return this.alunoRepository.save(entity);
		} else {
			// return null;
			return new Aluno();
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		this.alunoRepository.deleteById(id);
	}

	public Aluno matriculaCurso(Integer idAluno, Integer idCurso) throws Exception {
		Aluno aluno = get(idAluno);

		if (aluno.getId() == null) {
			throw new Exception("Aluno não encontrado!");
		}

		Curso curso = cursoService.get(idCurso);
		if (curso.getCodigo() == null) {
			throw new Exception("Curso não encontrado!");
		}

		if (aluno.getListaCursos().stream().filter(p -> p.getCodigo().compareTo(idCurso) == 0).findFirst()
				.isPresent()) {
			throw new Exception("Curso já adicionado para o aluno!");
		}

		aluno.getListaCursos().add(curso);
		return alunoRepository.save(aluno);
	}

	public void trancar(Aluno aluno) throws Exception {
		if (aluno.getMatricula() == null) {

			throw new Exception("Maticula não encontrada!");

		}
		if (!aluno.getMatricula().isEmpty()) {
			aluno.setSituacao("trancado");
			System.out.println("Matrícula trancada com sucesso.");

		}

	}

}