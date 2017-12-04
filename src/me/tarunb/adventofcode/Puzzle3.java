/**
 * AdventOfCode
 * <p>
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2017 Tarun Boddupalli
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package me.tarunb.adventofcode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Puzzle3 {

    static int[][] inputs;

    static {
        try {
            Scanner sc = new Scanner(new File("puzzle3.txt"));
            int count = 0;
            while (sc.hasNextLine()) {
                count ++;
                sc.nextLine();
            }
            sc.close();
            inputs = new int[count][3];

            sc = new Scanner(new File("puzzle3.txt"));
            for (int i = 0; i < count; i++) {
                inputs[i][0] = sc.nextInt();
                inputs[i][1] = sc.nextInt();
                inputs[i][2] = sc.nextInt();
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.printf("Solution 1: %d\n", solution1()); // 1032
        System.out.printf("Solution 2: %d\n", solution2()); // 1219
    }

    private static int solution1() {
        int count = 0;
        for (int[] lengths : inputs) {
            boolean ret = isValidTriangle(lengths[0], lengths[1], lengths[2]);
            if (ret) {
                count++;
            }
        }
        return count;
    }

    private static int solution2() {
        int count = 0;
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < inputs.length; y += 3) {
                boolean ret = isValidTriangle(inputs[y][x], inputs[y + 1][x], inputs[y + 2][x]);
                if (ret) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isValidTriangle(int l1, int l2, int l3) {
        return l1 + l2 > l3 && l2 + l3 > l1 && l1 + l3 > l2;
    }

}
