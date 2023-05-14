package com.github.martinnagy.javaoptimizationexercise;

import java.util.EnumSet;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.time.StopWatch;

public class SetExercise1 {
    public static void main(String[] args) {
        StopWatch stopWatch = StopWatch.createStarted();
        optimizeMe();
        System.out.println(stopWatch);
    }

    private static void optimizeMe() {
        Random random = new Random(0);
        Colors[] colorsArray = Colors.values();
        Set<Colors> myColors = EnumSet.of(Colors.BLACK, Colors.BLUE, Colors.PURPLE, Colors.ORANGE, Colors.TEAL);

        for (int i = 0; i < 500_000_000; i++) {
            myColors.contains(colorsArray[random.nextInt(colorsArray.length)]);
        }
    }

    private enum Colors {
        WHITE, BLACK, GRAY, PURPLE, BLUE, GREEN, YELLOW, ORANGE, RED, TURQUOISE, CYAN, TEAL, MAGENTA, PINK, KHAKI, BROWN,
    }
}
