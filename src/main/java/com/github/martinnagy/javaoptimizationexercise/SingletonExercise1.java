package com.github.martinnagy.javaoptimizationexercise;

import org.apache.commons.lang3.time.StopWatch;

public class SingletonExercise1 {
    public static void main(String[] args) {
        StopWatch stopWatch = StopWatch.createStarted();
        for (int i = 0; i < 500_000_000; i++) {
            OptimizeMe optimizeMe = OptimizeMe.getInstance();
        }
        System.out.println(stopWatch);
    }

    private static class OptimizeMe {
        private static OptimizeMe instance = null;

        static OptimizeMe getInstance() {
            if (instance != null) {
                return instance;
            }
            synchronized (OptimizeMe.class) {
                if (instance == null) {
                    instance = new OptimizeMe();
                }
            }
            return instance;
        }
    }
}
