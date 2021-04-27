package com.wjh.dp;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 */
public class 最长的回文子串 {

    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);

    }

//    public static String longestPalindrome(String s) {
//        if (s.length() <2 )
//            return s;
//        int m = s.length();
//        String resStr = s.substring(0,1);
//        for (int i = 0; i < m-1; i++) {
//            for (int j = i+1; j <m ; j++) {
//                String str = s.substring(i,j+1);
//                if (isFlag(str)){
//                    resStr = str.length() > resStr.length()?str:resStr;
//                }
//            }
//        }
//        return resStr;
//    }
//
//    //判断是否为回文子串
//    public static boolean isFlag(String s){
//        char[] chars = s.toCharArray();
//        int i = 0,j = chars.length-1;
//        while (i<j){
//            if (chars[i] != chars[j])
//                return false;
//            i++;
//            j--;
//        }
//
//        return true;
//    }


    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i]  =true;
        }
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] == true && (j-i+1) > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }


}
