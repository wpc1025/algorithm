package com.mrrookie.algorithm.stack;

import java.util.Stack;

/**
 * 小括号匹配
 * 栈
 */
public class Stack_01 {

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ('(' == c) {
                stack.push(c);
            }

            if (')' == c) {
                if (stack.empty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.empty();
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
