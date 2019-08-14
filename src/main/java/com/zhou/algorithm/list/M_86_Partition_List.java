package com.zhou.algorithm.list;

import com.zhou.algorithm.ListNode;

/**
 * @author changajingzhou
 * @description: 链表划分
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * @date 2019-07-15 22:25
 */
public class M_86_Partition_List {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;


        ListNode retHead = M_86_Partition_List.partitionList(listNode1,3);
        while (retHead != null){
            System.out.println(retHead.val);
            retHead = retHead.next;
        }




    }



    public static ListNode partitionList(ListNode head,int x){
        if (head == null || head.next == null){
            return head;
        }
        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);
        ListNode lessCur = lessHead;
        ListNode moreCur = moreHead;
        while (head != null){
            if(head.val < x){
                lessCur.next = head;
                lessCur = lessCur.next;
            }else {
                moreCur.next = head;
                moreCur = moreCur.next;
            }
            head = head.next;
        }
        lessCur.next = moreHead.next;
        moreCur.next = null;
        return lessHead.next;
    }
}
