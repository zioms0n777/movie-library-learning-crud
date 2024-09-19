package com.crudlearn.movie_library_learning_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {



    @Autowired
    MovieRepository movieRepository;

@GetMapping("")
    public List<Movie> getMovies() {
    return movieRepository.getAllMovies();
    }

    @GetMapping("/{id}")
public Movie getById(@PathVariable("id") int id) {
    return movieRepository.getById(id);
    }
    @PostMapping("")
    public int addMovie(@RequestBody List<Movie> movies) {
        return movieRepository.save(movies);
    }

    @PutMapping("/{id}")
    public int updateMovie(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.getById(id);
        if (movie != null) {

            movie.setName(updatedMovie.getName());
            movie.setRating(updatedMovie.getRating());


            return movieRepository.update(movie);
        } else {
            return -1;
        }
    }



    @PatchMapping("/{id}")
    public int patchMovie(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.getById(id);

        if (movie != null) {
            if (updatedMovie.getName() != null) movie.setName(updatedMovie.getName());
            if (updatedMovie.getRating() > 0) movie.setRating(updatedMovie.getRating());

            movieRepository.update(movie);

            return 1;
        } else {
            return -1;
        }
    }



    @DeleteMapping("/{id}")
    public int deleteMovie(@PathVariable("id") int id) {
    return movieRepository.delete(id);
    }

}

