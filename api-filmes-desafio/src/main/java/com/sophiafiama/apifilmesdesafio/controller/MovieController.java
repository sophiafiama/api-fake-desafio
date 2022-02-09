package com.sophiafiama.apifilmesdesafio.controller;

import com.sophiafiama.apifilmesdesafio.model.Movie;
import com.sophiafiama.apifilmesdesafio.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAll(){
        return ResponseEntity.ok(movieService.findMovies());
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<String> getById(@PathVariable Integer id){
        return ResponseEntity.ok(movieService.findById(id));
    }

    @GetMapping("/pages/{offset}/{pageSize}/{field}")
    public ResponseEntity<Page<Movie>> getPages(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field){
        return ResponseEntity.ok(movieService.pageMoviesSort(offset,pageSize,field));
    }

    @GetMapping("/byName")
    public ResponseEntity<Movie> getByName(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.findByName(movie.getName()));
    }


    @GetMapping("/director/pages")
    public ResponseEntity<Page<Movie>> getByDirector(@RequestBody Movie director, Pageable pageable){
        return ResponseEntity.ok(movieService.findByDirector(director.getDirector(), pageable ));
    }

    @GetMapping("/genre/pages")
    public ResponseEntity<Page<Movie>> getByGenre(@RequestBody Movie movie, Pageable pageable){
        return ResponseEntity.ok(movieService.findByGenre(movie.getGenre(), pageable));
    }


}
