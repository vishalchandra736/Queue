package com.blz.queue;

public class Node<T> {

        T data;
        Node <T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node() {

        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = null;
        }
    }
