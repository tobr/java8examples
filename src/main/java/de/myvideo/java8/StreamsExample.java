package de.myvideo.java8;


import de.myvideo.java8.model.Movie;
import de.myvideo.java8.service.MovieFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamsExample {
    private static final int MANY_VIEWS = 5_000;

    public static List<String> getMostViewedMovieNames(final List<Movie> movies) {
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


    public static void main(final String[] args) {
        List<Movie> movies = MovieFactory.sampleMovies();
        List<String> topMovieNames = StreamsExample.getMostViewedMovieNames(movies);
        System.out.println(topMovieNames.toString());

    }
}
