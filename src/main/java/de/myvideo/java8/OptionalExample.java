package de.myvideo.java8;

import de.myvideo.java8.model.Car;
import de.myvideo.java8.model.Insurance;
import de.myvideo.java8.model.Person;

public class OptionalExample {

    public static String getCarInsuranceName(final Person person) {
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

    public static void main(final String[] args) {
        String insuranceName = OptionalExample.getCarInsuranceName(new Person());

        System.out.println(insuranceName);
    }

}
