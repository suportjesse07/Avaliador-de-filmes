package com.equipe20.notafilme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.equipe20.notafilme.dto.MovieDTO;
import com.equipe20.notafilme.dto.ScoreDTO;
import com.equipe20.notafilme.entities.Movie;
import com.equipe20.notafilme.entities.Score;
import com.equipe20.notafilme.entities.User;
import com.equipe20.notafilme.repositories.MovieRepository;
import com.equipe20.notafilme.repositories.ScoreRepository;
import com.equipe20.notafilme.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);			
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double soma = 0.0;
		for(Score s: movie.getScores()) {
			soma = soma + s.getValue();
		}
		
		double media = soma / movie.getScores().size();
		
		movie.setScore(media);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
	
		
	}

