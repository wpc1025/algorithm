package com.mrrookie.algorithm.stack;

import java.util.Stack;

/**
 * 水中有许多鱼，可以认为这些鱼停放在 x 轴上。
 * 再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。
 * 这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。鱼的行为符合以下几个条件:
 * <p>
 * 1. 所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；
 * 2. 当方向相对时，大鱼会吃掉小鱼；
 * 3. 鱼的大小都不一样。
 * <p>
 * 请计算还剩下几条鱼？
 */
public class Stack_03 {
    public static int solution(int[] fishSize, int[] fishDir) {
        int fishNumber = fishSize.length;
        if (fishNumber <= 1) {
            return fishNumber;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < fishNumber; i++) {
            boolean hadEat = false;
            while (!stack.isEmpty() && fishDir[stack.peek()] == 1 && fishDir[i] == 0) {
                if (fishSize[i] > fishSize[stack.peek()]) {
                    stack.pop();
                }
                hadEat = true;
                break;
            }
            if (!hadEat) {
                stack.push(i);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[] fishSize = {5, 4, 3, 2, 1};
        int[] fishDir = {0, 1, 0, 1, 0};
        System.out.println(solution(fishSize, fishDir));
    }
}
