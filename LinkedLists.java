package com.blz.queue;
public class LinkedLists<T extends Comparable<T>> {

    Node<T> head;
    Node<T> tail;


    public LinkedLists() {
        this.head = null;
        this.tail = null;
    }

    public void append(T element) {
        Node<T> newNode = new Node<T>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else
            tail.next = newNode;
        tail = newNode;
    }

    public void add(T element) {
        Node<T> newNode = new Node<T>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else
            newNode.next = head;
        head = newNode;
    }

    public void sortAdd(T element) {
        Node<T> newNode = new Node<T>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (head.data.compareTo(newNode.data) > 0) {
            newNode.next = head;
            head = newNode;
        } else if (tail.data.compareTo(newNode.data) < 0) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node<T> thisNode = head.next;
            Node<T> previous = head;
            while (thisNode.data.compareTo(newNode.data) < 0 && thisNode != tail) {
                previous = thisNode;
                thisNode = thisNode.next;
            }
            previous.next = newNode;
            newNode.next = thisNode;
        }
    }

    public void printLinkedList() {
        Node<T> thisNode = head;

        if (thisNode == null)
            System.out.println("No elements in the list.\n");
        else {
            while (thisNode != null) {
                System.out.print(" -> " + thisNode.data);
                thisNode = thisNode.next;
            }
        }
    }

    public void search(T findElement) {
        Node<T> thisNode = head;

        while (thisNode != null) {
            if (thisNode.data == findElement) {
                System.out.println("\nFound element " + findElement + " in the Linked List!");
            }
            thisNode = thisNode.next;
        }
    }

    public void insert(T insertElement, T previous) {
        Node<T> newNode = new Node<T>(insertElement);

        Node<T> thisNode = head;
        while (thisNode.data != previous)
            thisNode = thisNode.next;

        newNode.next = thisNode.next;
        thisNode.next = newNode;
    }

    public void printSize() {
        Node<T> thisNode = this.head;
        int count = 0;

        if (thisNode == null)
            System.out.println("\nThe Linked list is empty.\n");
        else {
            while (thisNode != null) {
                count++;
                thisNode = thisNode.next;
            }
            System.out.println("\nSize of the Linked List : " + count);
        }
    }

    public int getSize() {
        Node<T> thisNode = this.head;
        int count = 0;

        if (thisNode == null)
            count = 0;
        else {
            while (thisNode != null) {
                count++;
                thisNode = thisNode.next;
            }
        }
        return count;
    }

    public void pop(T dataToRemove) {
        Node<T> thisNode = head;

        if (dataToRemove.equals(head.data)) {
            thisNode = head.next;
            head = thisNode;
        } else {
            Node<T> previous = null;
            while (!(thisNode.data.equals(dataToRemove))) {
                previous = thisNode;
                thisNode = thisNode.next;
            }
            previous.next = thisNode.next;
        }
    }
}