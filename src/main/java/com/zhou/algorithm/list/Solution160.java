package com.zhou.algorithm.list;

import com.zhou.algorithm.ListNode;

/**
 * @author changajingzhou
 * @description: 求两个链表的焦点
 * @date 2019-07-10 02:05
 */
public class Solution160 {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode headA = listNode1;
        ListNode headB = new ListNode(3);
        headB.next = listNode4;


        ListNode ret = getIntersectionNode(headA,headB);

        System.out.println(ret.val);


    }



    private static int getListLength(ListNode head){
        int ret = 0;
        while (head != null){
            ret ++;
            head = head.next;
        }
        return ret;
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1.求A的长度
        int lengthA = getListLength(headA);
        //2.求B的长度
        int lengthB = getListLength(headB);
        //3.将长的那个跳到一样长
        if(lengthA > lengthB){
            int margin = lengthA-lengthB;
            while (margin>0){
                headA = headA.next;
                margin--;
            }
        }else {
            int margin = lengthB-lengthA;
            while (margin>0){
                headB = headB.next;
                margin--;
            }
        }
        //4.同时遍历两个链表遇到同一节点返回，如果没有返回空
        while ( headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
