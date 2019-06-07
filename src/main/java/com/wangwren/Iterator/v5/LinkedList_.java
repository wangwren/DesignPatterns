package com.wangwren.Iterator.v5;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
class LinkedList_ implements Collection_ {
    Node head = null;
    Node tail = null;
    /**
     * 目前容器中有多少个元素
     */
    private int size = 0;

    @Override
    public void add(Object o) {
        Node n = new Node(o);
        n.next = null;

        if(head == null) {
            head = n;
            tail = n;
        }

        tail.next = n;
        tail = n;
        size++;
    }

    private class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator_{
        int cur = 0;

        @Override
        public boolean hasNext() {
            if (cur < size){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (cur == 0){
                cur ++;
                return head.o;
            }

            Node curNode = head;
            for (int i = 1; i <= cur; i++) {
                curNode = curNode.next;
                if (i == cur){
                    cur ++;
                    return curNode.o;
                }
            }

            return null;
        }
    }
}
