package com.zhou.algorithm.list;

import com.zhou.algorithm.ListNode;

/**
 * @author changajingzhou
 * @description: 206. Reverse Linked List
 * Reverse a singly linked list.
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * @date 2019-07-03 08:51
 */
public class Solution206 {
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

        Solution206 solution = new Solution206();

        ListNode head = listNode1;
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

        System.out.println("===");
        head = solution.reverseList(listNode1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }



    }


    /**
     * reverse list
     * 思路： 利用一个新的头指针，遍历原链表不断将头指针前移
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        ListNode newHead = null;
        ListNode next;
        // 遍历原链表
        while (head != null){
            //备份head.next
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
