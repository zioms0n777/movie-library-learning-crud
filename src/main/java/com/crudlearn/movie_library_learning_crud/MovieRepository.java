package com.crudlearn.movie_library_learning_crud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {



    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Movie> getAllMovies()
    {
        return jdbcTemplate.query("SELECT idmovie , name, rating FROM movie",
                BeanPropertyRowMapper.newInstance(Movie.class));
    }
    public Movie getById(int id)
    {
        return jdbcTemplate.queryForObject("SELECT idmovie" +  ", name, rating FROM movie WHERE " + " idmovie=?",
                BeanPropertyRowMapper.newInstance(Movie.class), id);
    }

    public int save(List<Movie> movies)
    {
        movies.forEach(movie -> jdbcTemplate
                .update("INSERT INTO movie (name, rating) VALUES (?, ?)", movie.getName(), movie.getRating()

                ));
        return 1;
    }


    public int update(Movie movie) {
        return jdbcTemplate.update("UPDATE movie SET name=?, rating=? WHERE idmovie=?",
                movie.getName(), movie.getRating(), movie.getIdmovie());
    }



    public int delete(int id) {
       return jdbcTemplate.update("DELETE FROM movie WHERE idmovie=?", id);
    }



}