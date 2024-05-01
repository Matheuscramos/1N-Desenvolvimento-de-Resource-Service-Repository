package br.com.senac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
