package com.example.demo;

//import  com.example.demo.Movie;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class AllMovies<method> {
    ArrayList<Movie> allMovies = new ArrayList<Movie>(Arrays.asList(
            new Movie("test"),
            new Movie("test2"),
            new Movie("test3"),
            new Movie("batman")
    ));


//request all movies
    @RequestMapping(value ="/get/all", method= GET)
    public Iterable<Movie> getMovies() {return allMovies;}

//request one specific movie with id
    @RequestMapping(value="/get/{id}", method= GET)
    public Movie getMovie(@PathVariable("id") Integer id) {
       return allMovies.stream().filter(movie -> movie.getId().equals(id)).findFirst().orElse(null);
    }

//create a new movie
    @RequestMapping(value = "/add/{name}", method = POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String newMovie(@PathVariable String name){
        Movie newMov = new Movie(name);
        allMovies.add(newMov);
        System.out.println("done "+name);
        return "posted";
    }

//update a movie
    @RequestMapping(value = "/change/{id}/{name}", method = PATCH)
    public String updateMovie(@PathVariable Integer id, @PathVariable String name){
        Movie myMov = allMovies.stream().filter(movie -> movie.getId().equals(id)).findFirst().orElse(null);
        myMov.updateName(name);
        return "updated";
    }

// delete a movie
    @RequestMapping(value = "/del/{id}", method = DELETE)
    public String deleteMovie(@PathVariable Integer id){
        allMovies.remove(id-1);
        return "deleted";
    }

}
