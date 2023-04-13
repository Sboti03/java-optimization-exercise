package com.github.martinnagy.javaoptimizationexercise;

import org.apache.commons.lang3.time.StopWatch;

public class StringExercise2 {
    public static void main(String[] args) {
        StopWatch stopWatch = StopWatch.createStarted();
        optimizeMe();
        System.out.println(stopWatch);
    }

    private static void optimizeMe() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100_00000; i++) {
            sb.append(i).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() -1);
        System.out.println(sb);
    }
}
