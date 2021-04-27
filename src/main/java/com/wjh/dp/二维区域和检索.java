package com.wjh.dp;

/**
 *
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 * 示例：
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 */
public class 二维区域和检索 {


    public static void main(String[] args) {


        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        二维区域和检索 m = new 二维区域和检索(matrix);
        int num1 = m.sumRegion(2, 1, 4, 3);
        int num2 = m.sumRegion(1, 1, 2, 2);
        int num3 = m.sumRegion(1, 2, 2, 4);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);

    }


    int[][] preNums;

    public 二维区域和检索(int[][] matrix) {
        preNums = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                preNums[i+1][j+1] = preNums[i][j+1]+preNums[i+1][j]-preNums[i][j]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return preNums[row2+1][col2+1] -preNums[row2+1][col1]-preNums[row1][col2+1]+preNums[row1][col1];

    }
}
