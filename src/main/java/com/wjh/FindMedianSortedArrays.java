package com.wjh;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double d = findMedianSortedArrays(nums1, nums2);
        System.out.println(d);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //合并数组
        int l1 = nums1.length - 1;
        int l2 = nums2.length - 1;
        int[] newArray = new int[nums1.length + nums2.length];
        int length = newArray.length - 1;
        while (l1 >= 0 && l2 >= 0) {
            newArray[length--] = nums1[l1] > nums2[l2] ? nums1[l1--] : nums2[l2--];
        }
        while (l1 >= 0) {
            newArray[length--] = nums1[l1--];
        }
        while (l2 >= 0) {
            newArray[length--] = nums2[l2--];
        }

        double result;
        if (newArray.length % 2 == 0) {
            result = (double) ((newArray[newArray.length / 2] + newArray[newArray.length / 2 - 1])) / 2;
            return result;
        } else {
            result = newArray[newArray.length / 2];
            return result;
        }

    }
}
