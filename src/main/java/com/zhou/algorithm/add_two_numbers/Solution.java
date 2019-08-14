package com.zhou.algorithm.add_two_numbers;

import com.zhou.algorithm.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
         ListNode l11 = new ListNode(4);
         ListNode l12 = new ListNode(6);
         l1.next = l11;
         l11.next = l12;


        ListNode l2 = new ListNode(5);
         ListNode l21 = new ListNode(6);
         ListNode l22 = new ListNode(4);
         l2.next = l21;
         l21.next = l22;


        Solution solution = new Solution();
        ListNode ret = solution.addTwoNumbers(l1, l2);

        while (ret != null) {
            System.out.print(ret.val + "-->");
            ret = ret.next;
        }


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.next == null && l1.val == 0 && l2.next == null && l2.val == 0) {
            return new ListNode(0);
        }

        ListNode head = null;//头结点
        ListNode temNode = null;//临时中间结点

        int preTem = 0;//进位
        int sumTem = 0;
        while (l1 != null  || preTem != 0 || l2!= null) {


            sumTem = 0;
            if (l1 != null) {
                if (l2 != null) {
                    sumTem = l1.val + l2.val + preTem;
                } else {
                    sumTem = l1.val + preTem;
                }
            } else {
                if (l2 != null) {
                    sumTem = l2.val + preTem;
                } else {
                    //tem1 和Tem 2都为空了 temNode不可能为空
                    sumTem = preTem;
                    temNode.next = new ListNode(sumTem);;
                    return head;
                }
            }

            preTem = 0; //进位使用完之后置零
            if (sumTem / 10 > 0) {
                preTem = sumTem / 10;
                sumTem = sumTem % 10;

            }
            if (temNode == null) {
                temNode = new ListNode(sumTem);
                head = temNode;
            } else {
                temNode.next = new ListNode(sumTem);;
                temNode = temNode.next;
            }
            if (l1!= null )l1 = l1.next;
            if (l2!= null )l2 = l2.next;
        }
        if (head.next == null && head.val == 0)
            head.next = new ListNode(1);

        return head;
    }
}
