package cn.glonk.api.may;

/**
 * Created with IntelliJ IDEA.
 *
 * @author： Yang
 * @date： 2022/5/6
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class May06 {

    //两数相加
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     */

    /**
     * 示例 1：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * <p>
     * 示例 2：
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * <p>
     * 示例 3：
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     */

    int val;
    May06 next;

    public May06() {

    }


    public May06(int val) {
        this.val = val;
    }

    public May06(int val, May06 next) {
        this.val = val;
        this.next = next;
    }


}

class Solution {

    private static May06 addTwoNumbers(May06 l1, May06 l2) {
        May06 head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new May06(sum % 10);
            } else {
                tail.next = new May06(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new May06(carry);
        }
        return head;
    }

}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0, newVal = 0;
        while (p1 != null || p2 != null || carry > 0) {
            newVal = (p1 == null ? 0: p1.val) + (p2 == null ? 0: p2.val) + carry;
            carry = newVal / 10;
            newVal %= 10;
            p.next = new ListNode(newVal);
            p1 = p1 == null? null: p1.next;
            p2 = p2 == null? null: p2.next;
            p = p.next;
        }
        return dummy.next;
    }
}*/
