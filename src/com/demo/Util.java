package com.demo;

public class Util {
    public static final String DEAD_CELL = " x ";
    public static final String ALIVE_CELL = " @ ";

    private Util() {
    }

    public static void printUniverse(int[][] universe) {
        for (int[] cells : universe) {
            for (int j = 0; j < universe.length; j++) {
                if (cells[j] == 1) {
                    System.out.print(ALIVE_CELL);
                } else {
                    System.out.print(DEAD_CELL);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
