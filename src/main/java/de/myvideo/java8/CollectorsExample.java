package de.myvideo.java8;


import de.myvideo.java8.model.Movie;
import de.myvideo.java8.model.MovieType;
import de.myvideo.java8.service.MovieFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CollectorsExample {

    private static void groupImperatively(final List<Movie> movies) {
        Map<MovieType, List<Movie>> moviesByMovieTypes = new HashMap<>();
        for (Movie movie : movies) {
            MovieType movieType = movie.getMovieType();
            List<Movie> moviesForMovieType = moviesByMovieTypes.get(movieType);
            if (moviesForMovieType == null) {
                moviesForMovieType = new ArrayList<>();
                moviesByMovieTypes.put(movieType, moviesForMovieType);
            }
            moviesForMovieType.add(movie);
        }

        movies.stream().collect(groupingBy(Movie::getMovieType, counting()));
        System.out.println(moviesByMovieTypes);
    }

    public static void main(final String[] args) {
        List<Movie> movies = MovieFactory.sampleMovies();
        CollectorsExample.groupImperatively(movies);
    }



}
