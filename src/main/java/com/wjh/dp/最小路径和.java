package com.wjh.dp;

import java.util.Arrays;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 */
public class 最小路径和 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,2,3},
                {4,5,6}
        };
        int pathSum = minPathSum(grid);
        System.out.println(pathSum);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = grid[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }

        }
        return dp[m][n];
    }
}
