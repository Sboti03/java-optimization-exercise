package com.github.martinnagy.javaoptimizationexercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;

public class MapExercise1 {
    public static void main(String[] args) {
        Random random = new Random(0);
        List<Name> names = IntStream.range(0, 5_000_000)
                .mapToObj(i -> new Name(randomLongString(random), randomLongString(random)))
                .toList();

        StopWatch stopWatch = StopWatch.createStarted();
        optimizeMe(names);
        System.out.println(stopWatch);
    }

    private static void optimizeMe(List<Name> names) {
        Map<Name, String> cache = new HashMap<>();

        for (Name name : names) {
            String value = cache.computeIfAbsent(name, n -> n.getFirstName() + " " + n.getLastName());
            System.out.println(value);
        }
    }

    private static String randomLongString(Random random) {
        return StringUtils.repeat(random.nextInt(10) + "", 50);
    }

    private static class Name {
        private final String firstName;
        private final String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

}
