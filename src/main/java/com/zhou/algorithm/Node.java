package com.zhou.algorithm;

/**
 * @author changajingzhou
 * @description: Definition for a Node.
 * @date 2019-07-15 22:56
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }


}
