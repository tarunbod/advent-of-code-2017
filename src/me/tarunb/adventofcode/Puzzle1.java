package me.tarunb.adventofcode;

import java.util.ArrayList;
import java.util.List;

public class Puzzle1 {

    static String input = "R2, L3, R2, R4, L2, L1, R2, R4, R1, L4, L5, R5, R5, R2, R2, R1, L2, L3, L2, L1, R3, L5, R187, R1, R4, L1, R5, L3, L4, R50, L4, R2, R70, L3, L2, R4, R3, R194, L3, L4, L4, L3, L4, R4, R5, L1, L5, L4, R1, L2, R4, L5, L3, R4, L5, L5, R5, R3, R5, L2, L4, R4, L1, R3, R1, L1, L2, R2, R2, L3, R3, R2, R5, R2, R5, L3, R2, L5, R1, R2, R2, L4, L5, L1, L4, R4, R3, R1, R2, L1, L2, R4, R5, L2, R3, L4, L5, L5, L4, R4, L2, R1, R1, L2, L3, L2, R2, L4, R3, R2, L1, L3, L2, L4, L4, R2, L3, L3, R2, L4, L3, R4, R3, L2, L1, L4, R4, R2, L4, L4, L5, L1, R2, L5, L2, L3, R2, L2";

    public static void main(String[] args) {
        System.out.printf("Solution 1: %s\n", solution1());
        System.out.printf("Solution 2: %s\n", solution2());
    }

    private static String solution1() {
        int dir = 0; // 0 north, 1 east, 2 south, 3 west
        int x = 0, y = 0;

        // shreyas is stupid

        String[] parts = input.split(", ");
        for (String part : parts) {
            char d = part.charAt(0);
            int steps = Integer.parseInt(part.substring(1));
            if (d == 'R') {
                dir ++;
            } else {
                dir --;
            }

            if (dir < 0) {
                dir = 3;
            }

            if (dir > 3) {
                dir = 0;
            }

            if (dir == 0) {
                y += steps;
            } else if (dir == 1) {
                x += steps;
            } else if (dir == 2) {
                y -= steps;
            } else {
                x -= steps;
            }
        }

        return Integer.toString(Math.abs(x + y));
    }

    private static String solution2() {
        int dir = 0;
        int x = 0, y = 0;

        List<String> locations = new ArrayList<>();

        String[] parts = input.split(", ");
        for (String part : parts) {
            char d = part.charAt(0);
            int steps = Integer.parseInt(part.substring(1));
            if (d == 'R') {
                dir ++;
            } else {
                dir --;
            }

            if (dir < 0) {
                dir = 3;
            }

            if (dir > 3) {
                dir = 0;
            }

            for (int i = 0; i < steps; i++) {
                if (dir == 0) {
                    y++;
                } else if (dir == 1) {
                    x++;
                } else if (dir == 2) {
                    y--;
                } else {
                    x--;
                }
                String loc = String.format("%d,%d", x, y);
                if (locations.contains(loc)) {
                    System.out.println(loc);
                    System.out.println(Integer.toString(Math.abs(x + y)));
                }
            }

            locations.add(String.format("%d,%d", x, y));
        }

        return Integer.toString(Math.abs(x + y));
    }

}
