package de.myvideo.java8.future;


public class Publicity {
    private String name;
    private int count;

    public Publicity(final String name, final int count) {
        this.name = name;
        this.count = count;
    }

    public static Publicity parse(String s) {
        String[] split = s.split(":");
        String name = split[0];
        int count = Integer.parseInt(split[1]);
        return new Publicity(name, count);
    }


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }
}
