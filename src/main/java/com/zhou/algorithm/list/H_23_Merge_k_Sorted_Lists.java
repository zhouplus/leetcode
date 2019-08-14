package com.zhou.algorithm.list;

import com.zhou.algorithm.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author changajingzhou
 * @description: 合并K个有序数组
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * @date 2019-07-16 00:20
 */
public class H_23_Merge_k_Sorted_Lists {

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



        ListNode retHead = mergeKLists(new ListNode[]{l1,l2});

        while (retHead != null){
            System.out.println(retHead.val);
            retHead = retHead.next;
        }






    }




    public static ListNode mergeKLists(ListNode[] lists) {


        List<ListNode> listRet = new ArrayList<ListNode>();
        for (ListNode temHead : lists){
            while (temHead != null){
                listRet.add(temHead);
                temHead = temHead.next;
            }
        }
        if(listRet.size() == 0){
            return  null;
        }
        if(listRet.size() == 1){
            return listRet.get(0);
        }
        Collections.sort(listRet, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i< listRet.size() - 1;i++){
            listRet.get(i).next = listRet.get(i+1);
        }
        return listRet.get(0);
    }
}
