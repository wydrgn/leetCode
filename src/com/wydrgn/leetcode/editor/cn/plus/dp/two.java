package com.wydrgn.leetcode.editor.cn.plus.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>动态规划-大信封装小信封</p>
 *
 * @author wydrgn
 * @date 2023/6/10
 */
public class two {
    public static void main(String[] args) {
        int[][] envelopes = new int[6][2];
        // 第一个信封
        envelopes[0][0] = 1;
        envelopes[0][1] = 8;
        // 第二个信封
        envelopes[1][0] = 6;
        envelopes[1][1] = 4;
        // 第三个信封
        envelopes[2][0] = 6;
        envelopes[2][1] = 7;
        // 第四个信封
        envelopes[3][0] = 5;
        envelopes[3][1] = 4;
        // 第五个信封
        envelopes[4][0] = 5;
        envelopes[4][1] = 2;
        // 第六个信封
        envelopes[5][0] = 2;
        envelopes[5][1] = 3;

        maxEnvelopes(envelopes);
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        int num = lenthOfLIS(height);
        System.out.println(num);
        return num;
    }

    public static int lenthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数 初始化0个
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    left = mid + 1;
                } else if (top[mid] < poker) {
                    right = mid;
                } else {
                    right = mid;
                }
            }

            if (left == piles) {
                // 没有适合的牌堆 新建一个牌堆
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }
}
