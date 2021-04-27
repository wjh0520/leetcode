package com.wjh.dp;

import java.util.Arrays;

/**
 * 背包问题：有一个背包，容量为 4 磅 ， 现有如下物品
 * <p>
 * 要求达到的目标为装入的背包的总价值最大，并且重量不超出
 * 要求装入的物品不能重复
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int amount = 4;
        int[] val = {1500, 3000, 2000};
        int[] w = {1, 4, 3};
        System.out.println(knapsackProblem(amount, val, w));

        //动态规划之选数问题
//        int[] arr = {1, 2, 4, 1, 7, 8, 3};
//        System.out.println(dp(arr));
//
//
//        //动态规划之最长公共子序列
//        System.out.println(longestCommonSubsequence("fnsvjkdhaj", "fnsvjkdhaj"));
//
//        //动态规划之最长公共子串
//        System.out.println(f("fnavjkdhcj", "fnsvjkdhaj"));
        //动态规划之数字三角形问题
//        int[][] num = new int[][]{
//                {9},
//                {12, 15},
//                {10, 6, 8},
//                {2, 18, 9, 5},
//                {19, 7, 10, 4, 16}
//        };
//
//        int i = dpMinNum(num);
//        System.out.println(i);

    }

    public static int knapsackProblem(int n, int[] val, int[] w) {
        int m = w.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (w[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], val[j - 1] + dp[i][i - w[j - 1]]);
                }
            }
        }

        return dp[n][m];
    }


    /**
     * 假设给定一串数字{1, 2, 4, 1, 7, 8, 3}，我们要从中选择若干个数，使最后的和达到最大。选择的规则是，不能选相邻的数字。
     * 比如：如果我们选了第一个数字1，那么我们就不能选2，如果我们选择了数字4，那么我们就不能选择与它相邻的2和1。
     *
     * @param arr
     * @return
     */
    public static int dp(int[] arr) {
        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        temp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            temp[i] = Math.max(arr[i] + temp[i - 2], temp[i - 1]);
        }
        return temp[arr.length - 1];
    }

    /**
     * abskfjks
     * ajdfklajdka
     * 动态规划之最长公共子序列
     *
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[len1][len2];
    }

    /**
     * abskfjks
     * ajdfklajdka
     * <p>
     * 动态规划之最长公共子串
     *
     * @return
     */
    public static String f(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int Strlen = 0;
        int begin = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > Strlen) {
                        Strlen = dp[i][j];
                        begin = i - Strlen;
                    }
                }
            }

        }
        return s1.substring(begin, begin + Strlen);
    }


    /**
     * 数字三角形问题
     * 给定一个由 n 行数字组成的数字三角形，试设计一个算法，
     * 计算出 从三角形的顶至底的一条路径，使该路径经过的数字总和最大。
     *
     * @param num
     * @return {9},
     * {12,15},
     * {10,6,8},
     * {2,18,9,5},
     * {19,7,10,4,16}
     */

    final static int N = 5;

    public static int dpMinNum(int[][] num) {
        int[][] dp = new int[N][N];
        dp[0][0] = num[0][0];
        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + num[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num[i][j];
                }
            }
        }
        int maxNum = dp[N - 1][0];
        for (int i = 1; i < N; i++) {
            if (dp[N - 1][i] > maxNum) {
                maxNum = dp[N - 1][i];
            }
        }
        return maxNum;
    }
}
