package de.myvideo.java8.service;


import de.myvideo.java8.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class StreamsExample {
    private static final int MANY_VIEWS = 5_000;

    public static List<String> getMostViewedMovieNamesIterative(final List<Movie> movies) {
        List<Movie> mostViewedMovies = new ArrayList<>();
        for (Movie m : movies) {
            if (m.getViewCount() > MANY_VIEWS) {
                mostViewedMovies.add(m);
            }
        }
        Collections.sort(mostViewedMovies, new Comparator<Movie>() {
            @Override
            public int compare(final Movie movie, final Movie other) {
                return other.getViewCount().compareTo(movie.getViewCount());
            }
        });

        List<String> mostViewedMovieTitles = new ArrayList<>();
        for (Movie m : mostViewedMovies) {
            mostViewedMovieTitles.add(m.getTitle());
        }

        return mostViewedMovieTitles;
    }


    public static void main(String[] args) {
        List<Movie> movies = MovieFactory.createMovies();
        List<String> topMovieNames = StreamsExample.getMostViewedMovieNamesIterative(movies);
        System.out.println(topMovieNames.toString());

    }
}
