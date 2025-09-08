package com.example.MovieJPA.repository;

import com.example.MovieJPA.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActorRepsoitory extends JpaRepository<Actor,Long> {
    Optional<Actor> findByNameIgnoreCase(String name);

}
