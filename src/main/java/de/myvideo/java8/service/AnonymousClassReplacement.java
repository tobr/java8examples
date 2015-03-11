package de.myvideo.java8.service;


import de.myvideo.java8.model.Movie;
import de.myvideo.java8.model.MovieType;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassReplacement {

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

        List<Movie> movies = Arrays.asList(
            new Movie(1, "Movie 1", 333, MovieType.FILM, true),
            new Movie(2, "Movie 2", 111, MovieType.MUSIC, true),
            new Movie(3, "Movie 3", 222, MovieType.MUSIC, true)
        );
        AnonymousClassReplacement.compareMoviesByViewCount(movies);
    }
}
