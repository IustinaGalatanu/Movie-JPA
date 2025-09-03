package com.example.MovieJPA.repository;

import com.example.MovieJPA.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByDirectorAndReleaseYear(String director, int releaseYear);
    List<Movie> findByWatchedFalse();
    List<Movie> findByWatchedTrue();
    List<Movie> findByRatingGreaterThan(Double minRating);

    @Query(value = "SELECT m FROM Movie m WHERE m.rating > :minRating")
    List<Movie> findMoviesByRatingWithSQL(Double minRating);

    @Query(value = "SELECT * FROM movies WHERE RATING > ?", nativeQuery = true)
    List<Movie> findMoviesByRatingWithNativeSQL(Double minRating);

}
