package de.myvideo.java8;

public class DefaultMethodExample {


    static interface B {
        public void hello();
    }
    static interface A extends B {
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static class C implements A {
        public void hello(){
            A.super.hello();
        }
    }

    public static void main(final String... args) {
        B b = new C();
        b.hello();
    }

}
