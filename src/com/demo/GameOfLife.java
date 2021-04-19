package com.demo;

import static com.demo.Util.printUniverse;

public class GameOfLife {

    public static void main(String[] args) {
        int demoUniverseSize = 25;
        int[][] zeroGeneration = new int[demoUniverseSize][demoUniverseSize];
        zeroGeneration[12][12] = 1;
        zeroGeneration[13][13] = 1;
        zeroGeneration[14][11] = 1;
        zeroGeneration[14][12] = 1;
        zeroGeneration[14][13] = 1;

        startSimulation(zeroGeneration, 100);
    }

    private static void startSimulation(int[][] zeroGeneration, int iterations) {
        System.out.println("Zero Generation");
        printUniverse(zeroGeneration);

        int[][] nextGeneration = zeroGeneration;
        for (int i = 1; i <= iterations; i++) {
            System.out.printf("Generation %d %n", i);
            nextGeneration = getNextGeneration(nextGeneration);
            printUniverse(nextGeneration);
        }
    }

    static int[][] getNextGeneration(int[][] previousGeneration) {
        int universeSize = previousGeneration.length;
        int[][] nextGeneration = new int[universeSize][universeSize];

        for (int i = 0; i < universeSize - 1; i++) {
            for (int j = 0; j < universeSize - 1; j++) {
                int aliveNeighbours = countAliveNeighbours(previousGeneration, i, j);
                if (previousGeneration[i][j] == 1 && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
                    nextGeneration[i][j] = 1;
                } else if (previousGeneration[i][j] == 0 && aliveNeighbours == 3) {
                    nextGeneration[i][j] = 1;
                } else {
                    nextGeneration[i][j] = 0;
                }
            }
        }

        return nextGeneration;
    }

    private static int countAliveNeighbours(int[][] generation, int i, int j) {
        int aliveNeighbours = 0;
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                if((k != 0 || l != 0) && i + k >= 0 && j + l >= 0 && i + k < generation.length && j + l < generation.length) {
                    aliveNeighbours += generation[i + k][j + l];
                }
            }
        }
        return aliveNeighbours;
    }

}
