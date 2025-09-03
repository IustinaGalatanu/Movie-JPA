package com.example.MovieJPA.service;

import com.example.MovieJPA.model.Movie;
import com.example.MovieJPA.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;

    public Movie save(Movie movie){
        return repository.save(movie);
    }

    public Optional<Movie> findById(Long id){
        return repository.findById(id);
    }

    public Iterable<Movie> findAll(){
        return repository.findAll();
    }

    public void delete(Long id){
         repository.deleteById(id);
    }

   public List<Movie> findByDirectorAndReleaseYear(String director, int releaseYear){
        return repository.findByDirectorAndReleaseYear(director,releaseYear);}
    public List<Movie> findByWatchedFalse() {
        return repository.findByWatchedFalse();
    }
    public List<Movie> findByWatchedTrue() {
        return repository.findByWatchedTrue();
    }
    public List<Movie> findByRatingGraterThan(Double minRating) {
        return repository.findByRatingGreaterThan(minRating);
    }

    public List<Movie> findMoviesByRatingWithSQL(Double rating){
        return repository.findMoviesByRatingWithSQL(rating);
    }

    public List<Movie> findMoviesByRatingWithNativeSQL(Double rating){
        return repository.findMoviesByRatingWithNativeSQL(rating);
    }

}

