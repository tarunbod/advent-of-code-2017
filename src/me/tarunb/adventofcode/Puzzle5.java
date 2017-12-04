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

import sun.security.provider.MD5;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Puzzle5 {

    static String input = "ojvtpuvg";

    public static void main(String[] args) {
        System.out.printf("Solution 1: %s\n", solution1()); // 4543c154
    }

    private static String solution1() {
        StringBuilder password = new StringBuilder();
        int idx = 0;
        while (password.length() < 8) {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update((input + idx).getBytes("UTF-8"));
                byte[] digest = md5.digest();
                char[] hash = new HexBinaryAdapter().marshal(digest).toCharArray();
                if (hash[0] == '0' && hash[1] == '0' && hash[2] == '0' && hash[3] == '0' && hash[4] == '0') {
                    password.append(hash[5]);
                }
                idx ++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return password.toString().toLowerCase();
    }

}
