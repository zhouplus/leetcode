package com.zhou.algorithm.list;

import com.zhou.algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author changajingzhou
 * @description:  链表求环
 * @date 2019-07-10 02:23
 */
public class Solution141 {


    public boolean hasCycle(ListNode head) {
        //借助set的唯一性往set中查找然后插入，如果存在则存在环
        Set<ListNode> listNodeSet = new HashSet<ListNode>();
        while (head != null){
            if(listNodeSet.contains(head)){
                return true;
            }else {
                listNodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
       // 当快指针赶上慢指针那就是有环
        ListNode slow = head;
        ListNode fast = head;
        //相遇节点
        ListNode meet = null;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                return false;
            }
            //fast再走一步
            fast = fast.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
