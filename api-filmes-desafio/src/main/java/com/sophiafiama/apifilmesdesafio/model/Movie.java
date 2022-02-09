package com.sophiafiama.apifilmesdesafio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String urlImage;
    private String genre;
    private String director;
    private Double rating = 0.0;
    private Integer counter = 0;

    @ElementCollection(targetClass = Double.class)
    private List<Double> ratings = new ArrayList<>();

    public Movie() {
    }

    public Movie(String name, String urlImage, String genre, String director) {
        this.name = name;
        this.urlImage = urlImage;
        this.genre = genre;
        this.director = director;
    }

    @Override
    public String toString() {
        return  " Filme : " + name  +
                "\n" +
                " Gênero : " + genre +
                "\n" +
                " Diretor: " + director  +
                "\n" +
                " Avaliação: " + rating +
                "\n" +
                " nº de Avaliações " + counter;
    }
}



