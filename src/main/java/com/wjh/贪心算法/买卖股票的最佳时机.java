package com.wjh.贪心算法;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        int[] prices = {7,5,3,6,4,2,56,9,11,25,36,95,12};
        int profit = maxProfit3(prices);
        System.out.println(profit);
    }

    /**
     * 暴力破解
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int maxMoney = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (prices[j] - prices[i] > maxMoney) {
                    maxMoney = prices[j] - prices[i];
                }
            }
        }
        return maxMoney;
    }

    /**
     * 动态规划
     *
     * dp[i][0]：规定了今天不持股，有以下两种情况：
     * 昨天不持股，今天什么都不做；
     * 昨天持股，今天卖出股票（现金数增加），
     *
     * dp[i][1]：规定了今天持股，有以下两种情况：
     * 昨天持股，今天什么都不做（现金数与昨天一样）；
     * 昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2)
            return 0;
        int[][] dp = new int[len][2];
        //dp[i][0]:不持股
        //dp[i][1]:持股
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[len-1][0];
    }

    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        int length = prices.length;
        int maxprofit = 0;
        int minprice = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (prices[i] < minprice){
                minprice = prices[i];
            }else if (prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

}
