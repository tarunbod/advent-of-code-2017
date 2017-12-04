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

public class Puzzle7 {

    static List<String> input = new ArrayList<>();
    static {
        try {
            Scanner sc = new Scanner(new File("puzzle7.txt"));
            while (sc.hasNextLine()) {
                input.add(sc.nextLine());;
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.printf("Solution 1: %d\n", solution1());
    }

    private static int solution1() {
        int count = 0;
        for (String line : input) {
            int hypernetStart = line.indexOf("["), hypernetEnd = line.indexOf("]");
            String hypernet = line.substring(hypernetStart + 1, hypernetEnd);
            if (containsABBA(hypernet)) {
                continue;
            }
            String nonHypernet = line.substring(0, hypernetStart) + line.substring(hypernetEnd + 1);
            if (containsABBA(nonHypernet)) {
                count++;
            }
        }
        return count;
    }

    // H E L L E O A M G
    private static boolean containsABBA(String str) {
        char[] chars = str.toCharArray();
        char a = chars[0], b = chars[1];
        for (int i = 1; i < chars.length - 2; i++) {
            if (a == b) {
                continue;
            }
            if (b == chars[i + 1] && a == chars[i + 2]) {
                return true;
            }
            a = b;
            b = chars[i + 1];
        }
        return false;
    }

}
