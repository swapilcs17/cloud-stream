package com.example.kafka.util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FluxMono {

    public void mono() {
        Mono<String> myMono = Mono.just("Real Madrid");
        StepVerifier.create(myMono.log()).expectNext("Real Madrid").verifyComplete();
    }

    public void fluxIterable() {
        List<String> names = Arrays.asList("Ronaldo","Messi","Bale");
        Flux<String> f = Flux.fromIterable(names);
        StepVerifier.create(f).expectNext("Ronaldo","Messi","Bale").verifyComplete();
    }

    public void fluxStream() {
        List<String> names = Arrays.asList("Ronaldo","Messi","Bale");
        Flux<String> fluxnames = Flux.fromStream(names.stream());
    }
    public void monoSupplier() {
        Supplier<String> stringSupplier = () -> "Real Madrid";
        Mono<String> stringMono = Mono.fromSupplier(stringSupplier);
        StepVerifier.create(stringMono.log())
                .expectNext("Real Madrid").verifyComplete();
    }

    public void fluxMap() {
        List<String> names = Arrays.asList("Ronaldo","Messi","Bale");
        Flux<String> nameFlux = Flux.fromIterable(names)
                .map(s -> s.toUpperCase())
                .log();
        StepVerifier.create(nameFlux)
                .expectNext("RONALDO","MESSI","BALE")
                .verifyComplete();
    }

    public void fluxFlatMap() {
        List<String> names = Arrays.asList("Ronaldo","Messi","Bale");
        Flux<String> nameFlux = Flux.fromIterable(names)
                .flatMap(s -> {
                    try {
                        return Flux.fromIterable(convertToList(s));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
        StepVerifier.create(nameFlux)
                .expectNextCount(6)
                .verifyComplete();
    }

    private List<String> convertToList(String s) throws InterruptedException {
        Thread.sleep(1000);
        return Arrays.asList(s, "newValue");
    }

    public static void main(String[] args) {
        FluxMono f = new FluxMono();
        f.fluxMap();
        f.fluxFlatMap();
    }
}
