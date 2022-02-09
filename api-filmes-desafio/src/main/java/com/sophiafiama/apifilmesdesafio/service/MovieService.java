package com.sophiafiama.apifilmesdesafio.service;

import com.sophiafiama.apifilmesdesafio.model.Movie;
import com.sophiafiama.apifilmesdesafio.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie){

       return movieRepository.save(movie);
    }

    public String findById(Integer id){
        if (id != null){
            return movieRepository.findById(id).get().toString();
        }
        return null;
    }


    public List<Movie> findMovies(){
        Sort sort = Sort.by("name").ascending();
        return movieRepository.findAll(sort);
    }


    public Movie findByName(String name){
        if (name != null) {
        Movie movie = movieRepository.findByName(name);
         return movie;
        }
        return null;
    }

    public Page<Movie> findByDirector(String director, Pageable pageable){
        if (director != null) {
            Page<Movie> directores = movieRepository.findByDirector(director, pageable);
            return directores;
        }
        return null;
    }
//
    public Page<Movie> findByGenre(String genre, Pageable pageable){
        if (genre != null) {
            return movieRepository.findByGenre(genre, pageable);
        }
        return null;
    }

    public Page<Movie> pageMoviesSort(int offset, int pageSize,String field){
        Page<Movie> movie =  movieRepository.findAll(PageRequest.of(offset,pageSize)
                .withSort(Sort.by(field)));
        return movie;
    }

    public Movie updateMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public String delete(Integer id){
        if (id != null){
            movieRepository.deleteById(id);
            return "Filme  deletado";
        }
        return null;
    }

    public String votar(Integer id, Double rating){
        if (id != null && rating< 4.1 ){
        Movie movie = movieRepository.findById(id).get();
        movie.setCounter(movie.getCounter()+1);
        List<Double> array = movie.getRatings();
        array.add(rating);
        Double result = array.stream().reduce(0.0,(a,b)->a+b);
        System.out.println(result);
        Double media = result/movie.getCounter();
        System.out.println(media);
        movie.setRating(media);
        movie.setRatings(array);
        movieRepository.save(movie);
        return "Nota atribuida com sucesso";
        }
        return "Você deve atribuir uma nota de 0.0 a 4.0";
        }
}
