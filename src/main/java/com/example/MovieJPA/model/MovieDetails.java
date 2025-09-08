package com.example.MovieJPA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Entity
@Table(name="movies_details")
public class MovieDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int duration;
    private String language;
    @Column(length = 500)
    private String synopsis;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MovieDetails details = (MovieDetails) o;
        return Objects.equals(id, details.id);
    }

    @Override
    public int hashCode() {
        return id != null? id.hashCode(id):0;
    }
}


