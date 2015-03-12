package de.myvideo.java8;

import de.myvideo.java8.model.Car;
import de.myvideo.java8.model.Insurance;
import de.myvideo.java8.model.Person;

import java.util.Optional;

public class OptionalExample {

    public String getCarInsuranceName(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

}
