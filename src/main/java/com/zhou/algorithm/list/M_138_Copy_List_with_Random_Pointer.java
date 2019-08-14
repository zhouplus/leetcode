package com.zhou.algorithm.list;

import com.zhou.algorithm.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author changajingzhou
 * @description: 复杂的链表的深度拷贝
 * @date 2019-07-15 22:51
 */
public class M_138_Copy_List_with_Random_Pointer {
    public static void main(String[] args) {
        Node node2 = new Node();
        node2.val = 8;
        node2.random = node2;
        node2.next = null;

        Node node1 = new Node();
        node1.val = 7;
        node1.next = node2;
        node1.random = node2;


        Node retHead = copyRandomList(node1);

        while (retHead != null){
            System.out.println("{" + retHead.val + "{" + retHead.next +"}" + retHead.random+"}");
            retHead = retHead.next;
        }

    }


    /**
     * 深度拷贝的节点困难在于
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        if(head == null ){
            return  null;
        }
        if ((head.next == null) && (head.random == null)){
            return new Node(head.val,null,null);
        }
        Map<Node,Integer> oldMap = new HashMap<Node, Integer>();
        Map<Integer,Node> newMap = new HashMap<Integer,Node>();
        //不要破坏头结点
        Node ptr = head;
        int i = 0;
        while (ptr!= null){
            oldMap.put(ptr,i);
            newMap.put(i,new Node(ptr.val,null,null));
            i ++;
            ptr = ptr.next;
        }
        ptr = head;
        i = 0;
        while (ptr!= null){
            newMap.get(i).next = newMap.get(i+1);
            if(ptr.random != null){
                newMap.get(oldMap.get(ptr)).random = newMap.get(oldMap.get(ptr.random));
            }
            i++;
            ptr = ptr.next;
        }
        return newMap.get(0);
    }
}
