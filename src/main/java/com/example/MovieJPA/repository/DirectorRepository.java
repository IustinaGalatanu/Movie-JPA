package com.example.MovieJPA.repository;

import com.example.MovieJPA.model.Director;
import com.example.MovieJPA.model.Genre;
import com.example.MovieJPA.model.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director,Long> {
    Optional<Director> findByNameIgnoreCase(String directorName);

}
