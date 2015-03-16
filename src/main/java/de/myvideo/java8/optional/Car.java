package de.myvideo.java8.optional;

import java.util.Optional;

public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(final Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}
