package br.com.senac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}
