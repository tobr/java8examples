package de.myvideo.java8;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamsExample {

    public static long iterativeSum(final long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sequentialSum(final long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    public static long parallelSum(final long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }

    public static long rangedSum(final long n) {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(final long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }


    public static void main(final String[] args) {
        System.out.println("Iterative Sum done in: " + measurePerf(ParallelStreamsExample::iterativeSum, 10_000_000L) + " msecs");
        //System.out.println("Sequential Sum done in: " + measurePerf(ParallelStreamsExample::sequentialSum, 10_000_000L) + " msecs");
        //System.out.println("Parallel forkJoinSum done in: " + measurePerf(ParallelStreamsExample::parallelSum, 10_000_000L) + " msecs" );
        //System.out.println("Range forkJoinSum done in: " + measurePerf(ParallelStreamsExample::rangedSum, 10_000_000L) + " msecs");
        //System.out.println("Parallel range forkJoinSum done in: " + measurePerf(ParallelStreamsExample::parallelRangedSum, 10_000_000L) + " msecs" );
    }



    private static <T, R> long measurePerf(final Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

}
