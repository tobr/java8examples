package de.myvideo.java8.future;

import static de.myvideo.java8.future.Util.delay;

public class ReportingServer {

    public static String writeSocialViewsToDB(Publicity publicity) {
        delay();
        return publicity.getName() + " mentions: " + publicity.getCount();
    }
}
