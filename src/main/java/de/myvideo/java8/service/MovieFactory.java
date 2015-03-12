package de.myvideo.java8.service;


import de.myvideo.java8.model.Movie;
import de.myvideo.java8.model.MovieType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class MovieFactory {

    public static List<Movie> sampleMovies() {
        return Arrays.asList(
                new Movie(1, "Hostage", 3854, MovieType.FILM, true),
                new Movie(2, "Austin Powers", 7262, MovieType.FILM, true),
                new Movie(3, "GNTM", 5683, MovieType.SERIES, true),
                new Movie(4, "Circus Halligalli", 9523, MovieType.SERIES, true),
                new Movie(5, "Michael Jackson", 2654, MovieType.MUSIC, true),
                new Movie(6, "Madonna", 4027, MovieType.MUSIC, true),
                new Movie(7, "Funny Clips", 333, MovieType.UGC, false),
                new Movie(8, "Big Boobs", 8638, MovieType.UGC, false),
                new Movie(9, "LALA", 10, MovieType.UGC, false)
        );
    }

    public static List<Movie> createRandomMovies(final int count) {
        List<Movie> movies = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            movies.add(new Movie(i, "Movie " + i, randInt(0, 10_000), MovieType.values()[randInt(0, 3)], randInt(0, 1) != 0));
        }

        return movies;
    }

    private static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
