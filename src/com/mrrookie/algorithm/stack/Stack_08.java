package com.mrrookie.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 字典序最小的 k 个数的子序列
 * 【题目】给定一个正整数数组和 k，要求依次取出 k 个数，输出其中数组的一个子序列，需要满足：1. 长度为 k；2.字典序最小。
 * <p>
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 接口：int[] findSmallSeq(int[] A, int k);
 */
public class Stack_08 {
    public static int[] findSmallSeq(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i] && (stack.size() + arr.length - i) > k) {
                stack.pop();
            }

            stack.push(arr[i]);
        }

        while (stack.size() > k) {
            stack.pop();
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 6};
        int k = 2;

        System.out.println(Arrays.toString(findSmallSeq(arr, k)));

        arr = new int[]{4, 8, 1, 9, 0, 1, 2};
        k = 4;
        System.out.println(Arrays.toString(findSmallSeq(arr, k)));
    }
}
