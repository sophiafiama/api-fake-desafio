package com.sophiafiama.apifilmesdesafio.controller;

import com.sophiafiama.apifilmesdesafio.model.Movie;
import com.sophiafiama.apifilmesdesafio.model.Role;
import com.sophiafiama.apifilmesdesafio.model.User;
import com.sophiafiama.apifilmesdesafio.service.MovieService;
import com.sophiafiama.apifilmesdesafio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class UserAdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;


    @GetMapping("/users/pages/{offset}/{pageSize}/{field}")
    public ResponseEntity<Page<User>> getPages(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
        return ResponseEntity.ok(userService.listAllUsers(offset,pageSize,field));
    }
    @PutMapping("disable/{id}")
    public ResponseEntity<String> disable(@PathVariable Integer id){
        return ResponseEntity.ok(userService.disable(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Usuario Deletado");
    }
    @PostMapping("/create")
    public ResponseEntity<User> postUser(@RequestBody User user){
           return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/update")
    public ResponseEntity<User> putUser(@RequestBody User user){
          return ResponseEntity.ok(userService.userUpdate(user));
    }

    @PostMapping("/movies/create")
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    @PutMapping("/movies/update")
    public ResponseEntity<Movie> putMovie(@RequestBody Movie movie){

        return ResponseEntity.ok(movieService.updateMovie(movie));
    }

    @DeleteMapping("/movies/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Integer id){
        movieService.delete(id);
        return ResponseEntity.ok("Filme Deletado");
    }

}
