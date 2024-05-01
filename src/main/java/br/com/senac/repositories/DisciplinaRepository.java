package br.com.senac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

}
