package com.pratica.AvProject2.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica.AvProject2.Entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    Optional<Aluno> findByMatricula(String matricula);
}
