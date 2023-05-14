package com.github.martinnagy.javaoptimizationexercise;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.time.StopWatch;

public class RemoveExercise1 {
    public static void main(String[] args) {
        Random random = new Random(0);
        List<Integer> numbers = IntStream.range(0, 500_000)
                .mapToObj(i -> random.nextInt())
                .collect(Collectors.toList());

        StopWatch stopWatch = StopWatch.createStarted();
        optimizeMe(numbers);
        System.out.println(stopWatch);
    }

    private static void optimizeMe(List<Integer> numbers) {
        numbers.removeIf(integer -> integer % 2 == 0);
    }

    private static void remove(ListIterator<Integer> iterator) {
        iterator.remove();
    }
}
