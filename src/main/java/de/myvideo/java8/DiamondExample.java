package de.myvideo.java8;


public class DiamondExample {

    static interface A {
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B extends A {
    }

    static interface C extends A {
    }

    static class D implements B, C {

    }

    public static void main(final String...args){
        new D().hello();
    }
}
