package com.wjh.course;
/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * java.lang.NullPointerException
 *   at line 22, Solution.addTwoNumbers
 *   at line 54, __DriverSolution__.__helper__
 *   at line 87, __Driver__.main
 */
public class AddTwoNumbers {
    public static void main(String[] args) {



    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode temp = l;
        int flag = 0,sum;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while(l1 != null || l2 != null){
            int x = l1 != null ? l1.val:0;
            int y = l2 != null ? l2.val:0;
            sum = (x+y+flag);
            flag = sum/10;
            sum = sum%10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2  =l2.next;
            }
        }

        if (flag > 0){
             temp.next = new ListNode(flag);
        }
        return l.next;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

