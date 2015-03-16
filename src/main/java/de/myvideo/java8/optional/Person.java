package de.myvideo.java8.optional;

import java.util.Optional;

public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(final Optional<Car> car) {
        this.car = car;
    }
}
