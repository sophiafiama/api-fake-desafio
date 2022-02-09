package com.sophiafiama.apifilmesdesafio.repository;

import com.sophiafiama.apifilmesdesafio.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

      @Query("select m from Movie m where m.name = ?1")
      Movie findByName(String name);
      Page<Movie> findByGenre(String genre, Pageable pageable);
      Page<Movie> findByDirector (String director, Pageable pageable);


}
