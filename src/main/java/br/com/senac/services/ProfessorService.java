package br.com.senac.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.interfaces.IService;
import br.com.senac.model.Professor;
import br.com.senac.repositories.ProfessorRepository;

@Service
public class ProfessorService implements IService<Professor, Integer> {

	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Professor create(Professor entity) {
		return professorRepository.save(entity);
	}

	@Override
	public Professor get(Integer id) {
		Optional<Professor> alunoEncontrado = professorRepository.findById(id);
		if (alunoEncontrado.isPresent()) {
			return alunoEncontrado.get();
		} else {
			return new Professor();
		}
	}

	@Override
	public List<Professor> get() {
		return professorRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Professor update(Integer id, Professor entity) {
		Professor professorEncontrado = this.get(id);
		if (professorEncontrado.getId() != 0 || professorEncontrado.getId() != null) {
			return professorRepository.save(entity);
		} else {
			// return null;
			return new Professor();
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		professorRepository.deleteById(id);
	}

}
