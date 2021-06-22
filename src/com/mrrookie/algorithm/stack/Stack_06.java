package com.mrrookie.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 数组中元素左边离我最近且比我小的元素的位置
 * 【题目】一个整数数组 A，找到每个元素：左边第一个比我小的下标位置，没有则用 -1 表示。
 * <p>
 * 输入：[2, 5]
 * <p>
 * 输出：[-1, 0]
 * <p>
 * 接口：int[] findLeftSmall(int[] A);
 */
public class Stack_06 {
    public static int[] findLeftSmall(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
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
        // [-1, 0, -1, 2, 3, 2, 2]
        System.out.println(Arrays.toString(findLeftSmall(arr)));


        arr = new int[]{7, 3, 8, 9, 1, 4, 2, 3, 5};
        // [-1, -1, 1, 2, -1, 4, 4, 6, 7]
        System.out.println(Arrays.toString(findLeftSmall(arr)));
    }
}
