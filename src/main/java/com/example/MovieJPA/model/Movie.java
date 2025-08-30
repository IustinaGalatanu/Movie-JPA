package com.example.MovieJPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private long id;

    private String title;
    private String director;
    private int relaseYear;
    private Double rating;
    private boolean watched;
}
