package br.com.senac.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.interfaces.IService;
import br.com.senac.model.Curso;
import br.com.senac.repositories.CursoRepository;

@Service
public class CursoService implements IService<Curso, Integer> {

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Curso create(Curso entity) {
		return this.cursoRepository.save(entity);
	}

	@Override
	public Curso get(Integer id) {
		Optional<Curso> cursoEncontrado = cursoRepository.findById(id);
		if (cursoEncontrado.isPresent()) {
			return cursoEncontrado.get();
		} else {
			return new Curso();
		}
	}

	@Override
	public List<Curso> get() {
		return this.cursoRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Curso update(Integer id, Curso entity) {
		Curso cursoEncontrado = this.get(id);
		if (cursoEncontrado.getCodigo() != 0 || cursoEncontrado.getCodigo() != null) {
			return this.cursoRepository.save(entity);
		} else {
			// return null;
			return new Curso();
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		this.cursoRepository.deleteById(id);
	}

}
