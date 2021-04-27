package com.wjh.course;

/**
 * 正整数n的这种表示称为正整数n的划分。求正整数n的不同划分个数。
 * 例如：正整数6有如下11种不同的划分：
 * 6；
 * 5+1；
 * 4+2，4+1+1；
 * 3+3，3+2+1，3+1+1+1；
 * 2+2+2，2+2+1+1，2+1+1+1+1；
 * 1+1+1+1+1+1。
 */
public class RoundNumber {


    public static void main(String[] args) {
        System.out.println(q2(6, 3));
    }


    //递归实现
    public static int q(int n,int m){
        if (n<1 || m<1)
            return 0;
        if (n == 1 || m == 1)
            return 1;
        if (n < m)
            return q(n,n);
        if (n == m)
            return q(n,n-1)+1;
        return q(n,m-1)+q(n-m,m);
    }

    //动态规划实现
    public static int q2(int n,int m){
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j < dp[0].length; j++) {
                if (i == j)
                    dp[i][j] = dp[i][j-1]+1;
                else if (i < j)
                    dp[i][j] = dp[i][i];
                else
                    dp[i][j] = dp[i][j-1]+dp[i-j][j];
            }

        }
        return dp[n][m];
    }



}
