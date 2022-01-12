package com.devsuperior.dsmovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;


@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);
		/*transformando o `Page de movies para uma Page de MovieDTO*/
		Page<MovieDTO> page=  result.map(x -> new MovieDTO(x));
		return page;		
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id).get(); //fazer tto de excessao
		/*transformando o `Page de movies para uma Page de MovieDTO*/
		MovieDTO dto = new MovieDTO(result);
		return dto;		
	}
	
	

}
