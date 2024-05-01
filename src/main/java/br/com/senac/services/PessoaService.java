package br.com.senac.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.interfaces.IService;
import br.com.senac.model.Pessoa;
import br.com.senac.repositories.PessoaRepository;

@Service
public class PessoaService implements IService<Pessoa, Integer> {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Pessoa create(Pessoa entity) {
		return pessoaRepository.save(entity);
	}

	@Override
	public Pessoa get(Integer id) {
		Optional<Pessoa> pessoaEncontrada = pessoaRepository.findById(id);
		if (pessoaEncontrada.isPresent()) {
			return pessoaEncontrada.get();
		} else {
			return new Pessoa();
		}
	}

	@Override
	public List<Pessoa> get() {
		return pessoaRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Pessoa update(Integer id, Pessoa entity) {
		Pessoa pessoaEncontrada = this.get(id);

		if (pessoaEncontrada.getId() != 0 || pessoaEncontrada.getId() != null) {
			return pessoaRepository.save(entity);
		} else {
			return new Pessoa();
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		pessoaRepository.deleteById(id);
	}

}
