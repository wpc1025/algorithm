package com.mrrookie.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 找到数组中右边比我小的元素（单调栈）
 * 【题目】一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。
 * <p>
 * 输入：[5, 2]
 * <p>
 * 输出：[1, -1]
 * <p>
 * 接口：int[] findRightSmall(int[] A);
 */
public class Stack_04 {
    public static int[] findRightSmall(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        // 存储最终结果
        int[] ans = new int[A.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            // 当栈不为空 且 栈顶元素对应数字大于当前值时，出栈，记录当前值索引
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                ans[stack.peek()] = i;
                stack.pop();
            }

            stack.push(i);
        }

        // 遍历之后，栈中剩余对应的右边最小的索引都为-1
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 0, 5, 6, 4, 2};
        // { 2,2,-1,5,5,6,-1}
        System.out.println(Arrays.toString(findRightSmall(arr)));


        arr = new int[]{7, 3, 8, 9, 1, 4, 2, 3, 5};
        // {1,4,4,4,-1,6,-1,-1,-1}
        System.out.println(Arrays.toString(findRightSmall(arr)));
    }
}
