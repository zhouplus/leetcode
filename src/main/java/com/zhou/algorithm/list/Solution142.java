package com.zhou.algorithm.list;

import com.zhou.algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author changajingzhou
 * @description:  链表求环
 * @date 2019-07-10 02:23
 */
public class Solution142 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        ListNode head = listNode1;

        ListNode ret = detectCycle(head);
        System.out.println(ret);
        System.out.println(ret.val);
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
       // 当快指针赶上慢指针那就是有环
        ListNode slow = head;
        ListNode fast = head;
        //相遇节点
        ListNode meet = null;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                return null;
            }
            //fast再走一步
            fast = fast.next;
            if(fast == slow){
                meet = fast;
                break;
            }
        }
        if(meet == null){
            return null;
        }
        while (head != null && meet != null){
            if(head == meet){
                return head;
            }
            head = head.next;
            meet= meet.next;
        }
        return null;
    }
}
