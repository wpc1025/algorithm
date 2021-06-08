package com.mrrookie.algorithm.stack;

import java.util.Stack;

/**
 * 小括号匹配-优化
 */
public class Stack_02 {

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 == 1) {
            return false;
        }

        int leftBracketNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ('(' == c) {
                leftBracketNumber++;
            }

            if (')' == c) {
                if (leftBracketNumber <= 0) {
                    return false;
                }

                leftBracketNumber--;
            }
        }

        return leftBracketNumber == 0;
    }

    public static void main(String[] args) {
        String s = "((())(";
        System.out.println(isValid(s));

        s = "((()))()()(())";
        System.out.println(isValid(s));

        s = "";
        System.out.println(isValid(s));

        s = "()(";
        System.out.println(isValid(s));
    }

}
