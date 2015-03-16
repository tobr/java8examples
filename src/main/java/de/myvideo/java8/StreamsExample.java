package de.myvideo.java8;


import de.myvideo.java8.model.Movie;
import de.myvideo.java8.factory.MovieFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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

    public static List<String> getMostViewedMovieNamesStreams(final List<Movie> movies) {
        return movies.stream()
                .filter(m -> m.getViewCount() > MANY_VIEWS)
                .sorted(Comparator.comparing(Movie::getViewCount).reversed())
                .map(Movie::getTitle)
                .collect(Collectors.toList());
    }


    public static List<String> getMostViewedMovieNamesStreamsOptimization(final List<Movie> movies) {
        return movies.stream()
                .filter(m -> {
                    System.out.println("filter " + m.getTitle());
                    return m.getViewCount() > MANY_VIEWS;
                })
                .sorted((movie, other) -> {
                    System.out.println("sort " + movie.getTitle());
                    return other.getViewCount().compareTo(movie.getViewCount());
                })
                .map((m) -> {
                    System.out.println("map " + m.getTitle());
                    return m.getTitle();
                })
                .collect(Collectors.toList());
    }

    public static List<String> getMostViewedMovieNamesStreamsShortCurcuiting(final List<Movie> movies) {
        return movies.stream()
                .filter(m -> {
                    System.out.println("filter " + m.getTitle());
                    return m.getViewCount() > MANY_VIEWS;
                })
                .map((m) -> {
                    System.out.println("map " + m.getTitle());
                    return m.getTitle();
                })
                .limit(3)
                .collect(Collectors.toList());
    }



    public static void main(final String[] args) {
        List<Movie> movies = MovieFactory.sampleMovies();
        List<String> topMovieNames = StreamsExample.getMostViewedMovieNames(movies);
        System.out.println(topMovieNames.toString());

    }
}
