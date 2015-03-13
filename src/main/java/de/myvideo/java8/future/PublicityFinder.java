package de.myvideo.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PublicityFinder {

    private final List<SocialNetwork> socialNetworks = Arrays.asList(
                                                   new SocialNetwork("Google"),
                                                   new SocialNetwork("Facebook"),
                                                   new SocialNetwork("Twitter"),
                                                  // new SocialNetwork("Instagram"),
                                                   new SocialNetwork("Pinterest"));

    private final Executor executor = Executors.newFixedThreadPool(socialNetworks.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    public List<String> findPublicitySequential(String product) {
        return socialNetworks.stream()
                .map(socialNetwork -> socialNetwork.getMentions(product))
                .map(Publicity::parse)
                .map(ReportingServer::writeSocialViewsToDB)
                .collect(Collectors.toList());
    }

    public List<String> findPublicityParallel(String product) {
        return socialNetworks.parallelStream()
                .map(socialNetwork -> socialNetwork.getMentions(product))
                .map(Publicity::parse)
                .map(ReportingServer::writeSocialViewsToDB)
                .collect(Collectors.toList());
    }

    public List<String> findPublicityFuture(String product) {
        List<CompletableFuture<String>> publicityFutures = socialNetworks.stream()
                .map(socialNetwork -> CompletableFuture.supplyAsync(() -> socialNetwork.getMentions(product), executor))
                .map(future -> future.thenApply(Publicity::parse))
                .map(future -> future.thenCompose(mention -> CompletableFuture.supplyAsync(() -> ReportingServer.writeSocialViewsToDB(mention), executor)))
                .collect(Collectors.<CompletableFuture<String>>toList());

        return publicityFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PublicityFinder publicityFinder = new PublicityFinder();
        execute("sequential", () -> publicityFinder.findPublicitySequential("MyVideo"));
        //execute("parallel", () -> publicityFinder.findPublicityParallel("MyVideo"));
        //execute("composed CompletableFuture", () -> publicityFinder.findPublicityFuture("MyVideo"));
    }

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }


}
