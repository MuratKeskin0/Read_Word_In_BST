package com.mycompany.wordgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic LinkedList class that handles data of any type.
 */
public class MyLinkedList<T> implements Iterable<T> {

    private LinkedListNode<T> head; // Head node of the list
    private int size = 0;  // Size of the list

    // Adds a new node with the specified data at the end of the list
    public void addLast(T data) {
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            LinkedListNode<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;  // Increment size with each new node
    }

    // Returns the size of the linked list
    public int getSize() {
        return size;
    }

    //for adding tree into Jlist
    public String[] toArray() {
        ArrayList<String> list = new ArrayList<>();
        LinkedListNode<T> temp = head;
        while (temp != null) {
            list.add(temp.data.toString());
            temp = temp.next;
        }
        return list.toArray(new String[0]);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private LinkedListNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public boolean contains(T data) {
        LinkedListNode<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}
