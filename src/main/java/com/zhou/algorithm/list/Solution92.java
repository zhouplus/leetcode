package com.zhou.algorithm.list;

import com.zhou.algorithm.ListNode;

/**
 * @author changajingzhou
 * @description: 92. Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * @date 2019-07-04 23:27
 */
public class Solution92 {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Solution92 solution = new Solution92();

        ListNode head = listNode1;
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

        System.out.println("===");
        head = solution.reverseBetween(listNode1,2,4);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n || m < 1) {
            return null;
        }
        //返回结果，非特殊情况返回头结点
        ListNode result = head;
        //要逆置的长度
        int changeLength = n-m+1;
        //要逆置的几个节点的前驱节点
        ListNode preHead = null;
        while (head != null && --m > 0) {
            preHead = head;
            head = head.next;
        }
        // 反转后的反转部分尾节点 就是反转前的头结点
        ListNode reverseTail = head;
        ListNode reverseNewHead = null;
        while (head != null && changeLength > 0) {
           ListNode next = head.next;
           head.next = reverseNewHead;
           reverseNewHead = head;
           head = next;
           changeLength --;
        }
        // 逆置后的尾节点的next 是 遍历后的head，此时head已经走到要逆置的部分的下一个节点了
        reverseTail.next = head;
        if(preHead != null){
            //不为空则将前驱节点与逆置后的头结点连接起来
            preHead.next = reverseNewHead;
        }else {
            //为空则说明m= 1
            result = reverseNewHead;
        }
        return result;
    }
}
