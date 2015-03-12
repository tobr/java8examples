package de.myvideo.java8.future;

import java.util.Random;

import static de.myvideo.java8.future.Util.delay;
import static de.myvideo.java8.future.Util.format;

public class SocialNetwork {

    private final String name;
    private final Random random;

    public SocialNetwork(final String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getMentions(final String product) {
        delay();
        return getName() + ":" + format(random.nextInt(1_000_000) * product.charAt(0) + product.charAt(1));
    }

    public String getName() {
        return name;
    }
}
