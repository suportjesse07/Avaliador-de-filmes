package com.equipe20.notafilme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equipe20.notafilme.dto.MovieDTO;
import com.equipe20.notafilme.entities.Movie;
import com.equipe20.notafilme.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
	
		Page<Movie> consulta = repository.findAll(pageable);		
		Page<MovieDTO> page = consulta.map(x -> new MovieDTO(x));		
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id){
	
		Movie consulta = repository.findById(id).get();		
		MovieDTO dto = new MovieDTO(consulta);		
		return dto;
	}

}
