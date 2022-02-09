package com.sophiafiama.apifilmesdesafio;

import com.sophiafiama.apifilmesdesafio.model.Movie;
import com.sophiafiama.apifilmesdesafio.model.Role;
import com.sophiafiama.apifilmesdesafio.model.User;
import com.sophiafiama.apifilmesdesafio.service.MovieService;
import com.sophiafiama.apifilmesdesafio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiFilmesDesafioApplication implements CommandLineRunner {

	@Autowired
	public MovieService movieService;

	@Autowired
	public UserService userService;



	public static void main(String[] args) {
		SpringApplication.run(ApiFilmesDesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		User user1 = new User("Sophia","sophia@teste.com", "senha");
		User user2 = new User("Pamela","pamela@teste.com","senha");
		User user3 = new User("Gustavo","gustavo@teste.com","senha");
		User user4 = new User("Eduardo","eduardo@teste.com","senha");
		User user5 = new User("Dulce","dulce@teste.com","senha");
		User user6 = new User("Nader","nader@teste.com","senha");
		User user7 = new User("Lauro","lauro@teste.com","senha");
		User user8 = new User("José","jose@teste.com","senha");
		User user9 = new User("Maria","maria@teste.com","senha");
		User user10 = new User("Vitor","vitor@teste.com","senha");

		user1.setRole(Role.ADMIN.getNome());

		userService.createUser(user1);
		userService.createUser(user2);
		userService.createUser(user3);
		userService.createUser(user4);
		userService.createUser(user5);
		userService.createUser(user6);
		userService.createUser(user7);
		userService.createUser(user8);
		userService.createUser(user9);
		userService.createUser(user10);



		Movie movie1 = new Movie("Pacto Sinistro", "https://www.themoviedb.org/img.jpg", "Suspense","Alfred Hitchcock");
		Movie movie2 = new Movie("Janela Indiscreta", "https://www.themoviedb.org/img.jpg", "Suspense","Alfred Hitchcock");
		Movie movie3 = new Movie("Taxi Driver", "https://www.themoviedb.org/img.jpg", "Crime","Martin Scorsese");
		Movie movie4 = new Movie("Touro Indomável ", "https://www.themoviedb.org/img.jpg", "Drama","Martin Scorsese");
		Movie movie5 = new Movie("Venom: Tempo de Carnificina", "https://www.themoviedb.org/img.jpg", "Heróis","Andy Serkis");
		Movie movie6 = new Movie("Vingadores: Era de Ultron", "https://www.themoviedb.org/img.jpg", "Heróis","Andy Serkis");
		Movie movie7 = new Movie("The Batman", "https://www.themoviedb.org/img.jpg", "Heróis","Andy Serkis");
		Movie movie8 = new Movie("Pantera Negra", "https://www.themoviedb.org/img.jpg", "Heróis","Andy Serkis");
		Movie movie9 = new Movie("The Batman 2", "https://www.themoviedb.org/img.jpg", "Heróis","Andy Serkis");
		Movie movie10 = new Movie("O Poderoso Chefão Parte III", "https://www.themoviedb.org/img.jpg", "Drama","Sofia Coppola");
		Movie movie11 = new Movie("Encontros e Desencontros", "https://www.themoviedb.org/img.jpg", "Drama","Sofia Coppola");
		Movie movie12 = new Movie("Harry Potter e as Relíquias da Morte - Parte 1", "https://www.themoviedb.org/img.jpg", "Adaptação","David Yates");
		Movie movie13 = new Movie("Kill Bill - Volume 1", "https://www.themoviedb.org/img.jpg", "Ação","Quentin Tarantino");
		Movie movie14 = new Movie("Pulp Fiction: Tempo de Violência", "https://www.themoviedb.org/img.jpg", "Crime","Quentin Tarantino");

		movieService.saveMovie(movie1);
		movieService.saveMovie(movie2);
		movieService.saveMovie(movie3);
		movieService.saveMovie(movie4);
		movieService.saveMovie(movie5);
		movieService.saveMovie(movie6);
		movieService.saveMovie(movie7);
		movieService.saveMovie(movie8);
		movieService.saveMovie(movie9);
		movieService.saveMovie(movie10);
		movieService.saveMovie(movie11);
		movieService.saveMovie(movie12);
		movieService.saveMovie(movie13);
		movieService.saveMovie(movie14);


	}




}
