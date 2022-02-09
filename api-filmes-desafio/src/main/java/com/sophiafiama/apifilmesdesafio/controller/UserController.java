package com.sophiafiama.apifilmesdesafio.controller;


import com.sophiafiama.apifilmesdesafio.model.User;
import com.sophiafiama.apifilmesdesafio.service.MovieService;
import com.sophiafiama.apifilmesdesafio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        return ResponseEntity.ok(userService.findById(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Sua conta foi Deletada");
    }

    @PostMapping("/create")
    public ResponseEntity<User> postUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/update")
    public ResponseEntity<User> putUser(@RequestBody User user){
        return ResponseEntity.ok(userService.userUpdate(user));
    }

    @PutMapping ("/rate/{id}")
    public ResponseEntity<String> putRate(@PathVariable Integer id, @RequestBody Double rating){
        return ResponseEntity.ok(movieService.votar(id, rating));
    }

    @PutMapping("disable/{id}")
    public ResponseEntity<String> disable(@PathVariable Integer id){
        return ResponseEntity.ok(userService.disable(id));
    }



}
