package com.wjh.dp;


/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *  
 */
public class 最长严格递增子序列 {

    public static void main(String[] args) {
        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lengthOfLIS2(nums));
//        System.out.println(binarySearch(0,2,4,new int[]{2,5,6}));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxtexs = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxtexs = Math.max(maxtexs, dp[i]);
        }
        return maxtexs;
    }

    //贪心+二分搜索
    public static int lengthOfLIS2(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int j = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > dp[j]) {
                dp[++j] = nums[i];
            } else {
                int index = binarySearch(0, j, nums[i], dp);
                dp[index] = nums[i];

            }
        }

        return j + 1;
    }

    public static int binarySearch(int start, int end, int target, int[] dp) {
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (dp[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
