package de.myvideo.java8.optional;

import java.util.Optional;

public class OptionalExample {

    public static String getCarInsuranceName(final Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }


    public static void main(final String[] args) {
        String insuranceName = OptionalExample.getCarInsuranceName(Optional.ofNullable(new Person()));

        System.out.println(insuranceName);
    }

}
