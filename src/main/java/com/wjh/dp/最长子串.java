package com.wjh.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 */
public class 最长子串 {

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring(new String("pwwkew"));
        System.out.println(i);
    }
    //方式一：
//    public static int lengthOfLongestSubstring(String s) {
//        int length = s.length();
//        int i = 0,j = 0,ans = 0;
//        for (i = 0;i<length;i++){
//            for (j = i+1; j <=length ; j++) {
//                if (allUnique(s,i,j)){
//                    ans = Math.max(ans,j-i);
//                }
//            }
//        }
//
//        return ans;
//    }

    //判断该字符串有没有重复字母
    public static boolean allUnique(String s,int start,int end){

        Set<Character> set = new HashSet<>();
        for (int i = start; i <end ; i++) {
            if (set.contains(s.charAt(i))) return false;
            set.add((s.charAt(i)));
        }
        return true;
    }

    //方式二：
//    public int lengthOfLongestSubstring(String s) {
//        int length = s.length();
//        Set<Character> set = new HashSet<>();
//        int i = 0,j = 0,ans = 0;
//        while (i<length && j<length){
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans = Math.max(ans,j-i);
//            }else {
//                set.remove(s.charAt(i++));
//            }
//        }
//
//        return ans;

    //方式三
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        for (int j = 0,i = 0; j <length ; j++) {
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j+1);
        }

        return ans;
    }

  //  }
}
