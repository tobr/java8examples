package de.myvideo.java8.service;


import de.myvideo.java8.model.Movie;

import java.util.Comparator;
import java.util.function.Supplier;

public class MovieService {

    public void test() {
        Supplier<Movie> m = Movie::new;

        Comparator<Movie> byWeight =
                new Comparator<Movie>() {
                    @Override
                    public int compare(final Movie a1, final Movie a2) {
                        return a1.getViewCount().compareTo(a2.getViewCount());
                    }
                };
    }
}
