package br.com.senac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
