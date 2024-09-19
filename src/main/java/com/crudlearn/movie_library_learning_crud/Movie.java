package com.crudlearn.movie_library_learning_crud;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private int idmovie;
    private String name;
    private Double rating;

}
