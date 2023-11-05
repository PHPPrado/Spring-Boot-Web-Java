package com.universidade.universidade.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversidadeRepository extends JpaRepository<Universidade, Integer> {
    Universidade findByNome(String nome);
}
