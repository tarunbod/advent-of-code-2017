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
import java.util.*;

public class Puzzle6 {

    static List<String> input = new ArrayList<>();
    static {
        try {
            Scanner sc = new Scanner(new File("puzzle6.txt"));
            while (sc.hasNextLine()) {
                input.add(sc.nextLine());;
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.printf("Solution 1: %s\n", solution1()); // liwvqppc
    }

    private static String solution1() {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            HashMap<Character, Integer> charsMap = new HashMap<>();
            for (int j = 0; j < input.size(); j++) {
                char c = input.get(j).charAt(i);
                charsMap.put(c, charsMap.getOrDefault(c, 0) + 1);
            }
            char c = getMax(charsMap);
            message.append(c);
        }
        return message.toString();
    }

    private static char getMax(Map<Character, Integer> count) {
        char c = 0;
        int max = 0;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                c = entry.getKey();
            }
        }
        return c;
    }

}
