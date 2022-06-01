package com.equipe20.notafilme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.equipe20.notafilme.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
//Os parâmetros do JpaRepository são parâmetros para a tabela.
//Essa interface vai fazer as operações CRUD NO BANCO DE DADOS.	

}
