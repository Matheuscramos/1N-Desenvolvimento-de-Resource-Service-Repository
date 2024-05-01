package br.com.senac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
