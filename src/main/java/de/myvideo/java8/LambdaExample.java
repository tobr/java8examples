package de.myvideo.java8;


import de.myvideo.java8.model.Movie;
import de.myvideo.java8.factory.MovieFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExample {

    public static void compareMoviesByViewCount(final List<Movie> movies) {
        Comparator<Movie> byViewCount =
                new Comparator<Movie>() {
                    @Override
                    public int compare(final Movie movie, final Movie other) {
                        return other.getViewCount().compareTo(movie.getViewCount());
                    }
                };

        Collections.sort(movies, byViewCount);
        System.out.println(movies);
    }

    public static void compareMoviesByViewCountLambda(final List<Movie> movies) {
        Collections.sort(movies, Comparator.comparing(Movie::getViewCount).reversed());
        System.out.println(movies);
    }

    public static void main(final String[] args) {
        LambdaExample.compareMoviesByViewCount(MovieFactory.sampleMovies());
        LambdaExample.compareMoviesByViewCountLambda(MovieFactory.sampleMovies());
    }
}
