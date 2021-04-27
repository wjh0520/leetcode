package com.wjh.dp;

/**
 * 不同路径II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 */
public class 不同路径II {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0,1},
                {0,0}
        };
        int paths = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(paths);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (i == 1 && j == 1 && obstacleGrid[0][0] == 0){
                    dp[i][j] = 1;
                    continue;
                }
                if (obstacleGrid[i-1][j-1] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

}
