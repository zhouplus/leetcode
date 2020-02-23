package com.zhou.algorithm;
//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。
//
// 进阶:
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
// 示例:
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
//
// Related Topics 设计


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class MyLRUCache {

    //存储数据的容器， 查询速度O(1)
    private final HashMap<Integer, Entry> hashMap;

    //双向链表头结点
    private Entry head;
    //双向链表尾结点
    private Entry tail;


    class Entry {
        private int key;
        private int value;
        private Entry next;
        private Entry prev;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    public MyLRUCache(final int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<Integer, Entry>(capacity, 0.75f);
        this.head = new Entry(-1, -1);
        this.tail = new Entry(-1, -1);
        //注意用来实现的是双向链表而不是双向循环链表
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        // 1 hashMap中查询
        if (hashMap.containsKey(key)) {
            // 2 查询到的话更新元素在双向链表中的位置，更新到末尾，为了维护自然使用的最新时间
            Entry entry = hashMap.get(key);
            _transEntryToTail(entry);
            return entry.value;
        }
        return -1;
    }

    /**
     * 将元素转移到尾结点前面
     *
     * @param entry
     */
    private void _transEntryToTail(Entry entry) {
        // 删除自己
        Entry prev = entry.prev;
        Entry next = entry.next;
        prev.next = next;
        next.prev = prev;
        // 转移到尾节点
        Entry tailPrev = tail.prev;
        tailPrev.next = entry;
        entry.prev = tailPrev;
        entry.next = tail;
        tail.prev = entry;
    }

    public void put(int key, int value) {
        Entry entry;
        if (hashMap.containsKey(key)) {
            //如果key存在
            entry = hashMap.get(key);
            entry.value = value;
            _transEntryToTail(entry);
        } else {
            //缓存满的话，淘汰头元素的下一个元素
            if (hashMap.size() >= capacity) {
                _removeHeadNext();
            }
            // 如果key不存在
            entry = new Entry(key, value);
            hashMap.put(key, entry);
            _addToTailPrev(entry);
        }
    }

    /**
     * 新节点加入到尾结点前面
     *
     * @param entry
     */
    private void _addToTailPrev(Entry entry) {
        Entry tailPrev = tail.prev;

        tailPrev.next = entry;
        entry.prev = tailPrev;
        entry.next = tail;
        tail.prev = entry;
    }

    /**
     * 移除头结点的下一个节点
     */
    private void _removeHeadNext() {
        Entry headNext = head.next;
        headNext.next.prev = head;
        head.next = headNext.next;
        this.hashMap.remove(headNext.key);
    }


    public static void main(String[] args) {
        MyLRUCache cache = new MyLRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));



    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
