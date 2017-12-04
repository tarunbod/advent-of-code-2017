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
import java.io.FileNotFoundException;
import java.util.*;

public class Puzzle4 {

    static List<String> input = new ArrayList<>();

    static {
        try (Scanner sc = new Scanner(new File("puzzle4.txt"))) {
            while (sc.hasNextLine()) {
                input.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.printf("Solution 1: %d\n", solution1()); // 245102
    }

    private static int solution1() {
        int sum = 0;
        for (String line : input) {
            String checksum = getChecksum(line);
            int sectorID = getSectorID(line);
            line = line.substring(0, line.lastIndexOf("-"));
            char[] chars = line.toCharArray();
            SortedMap<Character, Integer> count = new TreeMap<>();
            for (char c : chars) {
                if (c == '-') continue;
                count.put(c,  count.getOrDefault(c, 0) + 1);
            }
            char[] highest = new char[5];
            for (int i = 0; i < 5; i++) {
                char c = getMax(count);
                highest[i] = c;
                count.remove(c);
            }
            if (new String(highest).equalsIgnoreCase(checksum)) {
                sum += sectorID;
            }
        }
        return sum;
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

    private static String getChecksum(String line) {
        return line.substring(line.length() - 6, line.length() - 1);
    }

    private static int getSectorID(String line) {
        int lastDashIndex = line.lastIndexOf("-");
        int rBracketIndex = line.indexOf("[");
        return Integer.parseInt(line.substring(lastDashIndex + 1, rBracketIndex));
    }

}
