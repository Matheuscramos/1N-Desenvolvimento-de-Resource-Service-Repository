package br.com.senac.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.interfaces.IService;
import br.com.senac.model.Turma;
import br.com.senac.repositories.TurmaRepository;

@Service
public class TurmaService implements IService<Turma, Integer> {

	@Autowired
	private TurmaRepository turmaRepository;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Turma create(Turma turma) {
		return this.turmaRepository.save(turma);
	}

	@Override
	public Turma get(Integer id) {

		Optional<Turma> turmaEncontrada = turmaRepository.findById(id);
		return turmaEncontrada.orElseGet(Turma::new);
	}

	@Override
	public List<Turma> get() {
		return this.turmaRepository.findAll();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public Turma update(Integer id, Turma turma) {
		Turma turmaEncontrada = this.get(id);

		if (turmaEncontrada.getId() != null && turmaEncontrada.getId() != 0) {
			return this.turmaRepository.save(turma);
		} else {
			return new Turma();
		}
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void delete(Integer id) {
		this.turmaRepository.deleteById(id);
	}

}
