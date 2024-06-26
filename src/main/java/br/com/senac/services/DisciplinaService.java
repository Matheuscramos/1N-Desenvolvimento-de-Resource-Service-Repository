package br.com.senac.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.interfaces.IService;
import br.com.senac.model.Disciplina;
import br.com.senac.repositories.DisciplinaRepository;

@Service
public class DisciplinaService implements IService<Disciplina, Integer> {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Disciplina create(Disciplina entity) {
		return this.disciplinaRepository.save(entity);
	}

	@Override
	public Disciplina get(Integer id) {
		Optional<Disciplina> disciplinaEncontrado = disciplinaRepository.findById(id);
		if (disciplinaEncontrado.isPresent()) {
			return disciplinaEncontrado.get();
		} else {
			return new Disciplina();
		}
	}

	@Override
	public List<Disciplina> get() {
		return this.disciplinaRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Disciplina update(Integer id, Disciplina entity) {
		Disciplina disciplinaEncontrado = this.get(id);
		if (disciplinaEncontrado.getCodigo() != 0 || disciplinaEncontrado.getCodigo() != null) {
			return this.disciplinaRepository.save(entity);
		} else {
			return new Disciplina();
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		this.disciplinaRepository.deleteById(id);
	}

}
