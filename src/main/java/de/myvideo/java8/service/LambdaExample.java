package de.myvideo.java8.service;


import de.myvideo.java8.model.Movie;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExample {

    public static void compareMoviesByViewCount(List<Movie> movies) {
        Comparator<Movie> byViewCount =
                new Comparator<Movie>() {
                    @Override
                    public int compare(final Movie movie, final Movie other) {
                        return movie.getViewCount().compareTo(other.getViewCount());
                    }
                };

        Collections.sort(movies, byViewCount);
        System.out.println(movies);
    }

    public static void main(String[] args) {
        LambdaExample.compareMoviesByViewCount(MovieFactory.createMovies());
    }
}
