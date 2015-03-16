package de.myvideo.java8;


import de.myvideo.java8.model.Movie;
import de.myvideo.java8.model.MovieType;
import de.myvideo.java8.factory.MovieFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingInt;

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

        System.out.println(moviesByMovieTypes);
    }

    private static void groupFunctionally(final List<Movie> movies) {
        Map<MovieType, List<Movie>> moviesByMovieTypes = movies.stream()
                .collect(groupingBy(Movie::getMovieType));
        System.out.println(moviesByMovieTypes);
    }

    private static void groupByMovieType(final List<Movie> movies) {
        Map<MovieType, Long> moviesByMovieTypes = movies.stream()
                .collect(groupingBy(Movie::getMovieType, counting()));
        System.out.println(moviesByMovieTypes);
    }

    private static void groupByMovieTypeAndViews(final List<Movie> movies) {
        Map<MovieType, Integer> moviesByMovieTypes = movies.stream()
                .collect(groupingBy(Movie::getMovieType, summingInt(Movie::getViewCount)));
        System.out.println(moviesByMovieTypes);
    }

    private static void mostViewedMovieComparator(final List<Movie> movies) {
        Optional<Movie> mostViewedMovie = movies.stream()
                .collect(maxBy(comparingInt(Movie::getViewCount)));
        System.out.println(mostViewedMovie.get());
    }

    private static void mostViewedMovie(final List<Movie> movies) {
        Movie mostViewedMovie = movies.stream()
                .collect(reducing((m1, m2) -> m1.getViewCount() > m2.getViewCount() ? m1 : m2)).get();
        System.out.println("mostViewedMovie: " + mostViewedMovie);
    }

    private static void getMostViewedMovieByMovieType(final List<Movie> movies) {
        Map<MovieType, Movie> moviesByMovieTypes = movies.stream()
                .collect(groupingBy(
                        Movie::getMovieType,
                        collectingAndThen(maxBy(comparingInt(Movie::getViewCount)),Optional::get)));
        System.out.println(moviesByMovieTypes);
    }


    private static void getMovieTitlesAsString(final List<Movie> movies) {
        String movieTitles = movies.stream().map(Movie::getTitle).collect(joining(", "));
        System.out.println("movieTitles: " + movieTitles);
    }


    public static void main(final String[] args) {
        List<Movie> movies = MovieFactory.sampleMovies();
        CollectorsExample.groupImperatively(movies);
        CollectorsExample.groupFunctionally(movies);
        CollectorsExample.groupByMovieType(movies);
        CollectorsExample.groupByMovieTypeAndViews(movies);
        CollectorsExample.mostViewedMovieComparator(movies);
        CollectorsExample.mostViewedMovie(movies);
        CollectorsExample.getMostViewedMovieByMovieType(movies);
        CollectorsExample.getMovieTitlesAsString(movies);
    }



}
