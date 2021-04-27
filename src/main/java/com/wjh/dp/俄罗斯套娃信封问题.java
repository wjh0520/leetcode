package com.wjh.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 示例 1：
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 示例 2：
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 */
public class 俄罗斯套娃信封问题 {

    public static void main(String[] args) {
        //[[4,5],[4,6],[6,7],[2,3],[1,1]]
        System.out.println(maxEnvelopes2(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3},{1,1}}));
    }
    //动态规划
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else {
                    return o2[1] - o1[1];
                }
            }
        });

        int dp[] = new int[n];
        int res = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                res = Math.max(res,dp[i]);
            }
        }
        return res;
    }

    //二分搜索+贪心

    public static int maxEnvelopes2(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else {
                    return o2[1] - o1[1];
                }
            }
        });

        int[] tails = new int[n+1];
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (envelopes[i][1] > tails[end]){
                tails[++end] = envelopes[i][1];
            }else {
                int l = 1, r = end, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (tails[mid] < envelopes[i][1]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                tails[pos + 1] = envelopes[i][1];
            }
        }

        return end;


    }



}
