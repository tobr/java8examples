package de.myvideo.java8;

public class DefaultMethodExample {

    static interface A{
        public default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B {
        public default void hello() {
            System.out.println("Hello from B");
        }
    }

    static class C implements B, A {
        public void hello(){
            A.super.hello();
        }
    }

    public static void main(final String... args) {
        new C().hello();
    }

}
