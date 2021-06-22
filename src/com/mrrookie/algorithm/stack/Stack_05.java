package com.mrrookie.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 找到数组中右边比我大的元素（单调栈）
 * 【题目】一个整数数组 A，找到每个元素：右边第一个比我大的下标位置，没有则用 -1 表示。
 * <p>
 * 输入：[2, 5]
 * <p>
 * 输出：[1, -1]
 * <p>
 * 接口：int[] findRightBig(int[] A);
 */
public class Stack_05 {
    public static int[] findRightBig(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[stack.peek()] = i;
                stack.pop();
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 0, 5, 6, 4, 2};
        // [1, 3, 3, 4, -1, -1, -1]
        System.out.println(Arrays.toString(findRightBig(arr)));


        arr = new int[]{7, 3, 8, 9, 1, 4, 2, 3, 5};
        // [2, 2, 3, -1, 5, 8, 7, 8, -1]
        System.out.println(Arrays.toString(findRightBig(arr)));
    }
}
