package com.zhou.algorithm.list;

import com.zhou.algorithm.ListNode;

import java.util.List;

/**
 * @author changajingzhou
 * @description: 合并两个有序链表
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * @date 2019-07-15 23:40
 */
public class E_21_Merge_Two_Sorted_Lists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l1.next = l11;
        l11.next = l12;


        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;



        ListNode lp1 = l1;
        while (lp1 != null){
            System.out.println(lp1.val);
            lp1 = lp1.next;
        }

        System.out.println("===");
        ListNode lp2 = l2;
        while (lp2 != null){
            System.out.println(lp2.val);
            lp2 = lp2.next;
        }

       System.out.println("===");
        ListNode retHead = mergeTwoLists(l1,l2);
        while (retHead != null){
            System.out.println(retHead.val);
            retHead = retHead.next;
        }


    }



    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newHead = new ListNode(0);
        ListNode ptr = newHead;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ptr.next = l1;
                l1 = l1.next;
            }else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        if (l1 != null){
            ptr.next = l1;
        }
        if(l2 != null){
            ptr.next = l2;
        }
        return newHead.next;
    }
}
