package com.tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * * Created with IntelliJ IDEA.
 * User: Andrew2212<br/>
 *
 * @param <T1> key
 * @param <T2> value
 */
@SuppressWarnings("unused")
public class Node<T1 extends Comparable<T1>, T2> {

    private T1 key;
    private T2 value;
    private Node<T1, T2> left;
    private Node<T1, T2> right;
    private AtomicInteger count = new AtomicInteger(1);

    public Node(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                ", count=" + count +
                '}';
    }

    public void addNextNode(T1 key, T2 value) {

        int compare = key.compareTo(getKey());

        if (compare == 0) {
            setValue(value);
            return;
        }

        Node<T1, T2> nodeNext;

        if (compare < 0) {
            nodeNext = getLeft();
            if (nodeNext != null) {
                nodeNext.addNextNode(key, value);
            } else {
                setLeft(new Node<T1, T2>(key, value));
            }
        }

        if (compare > 0) {
            nodeNext = getRight();
            if (nodeNext != null) {
                nodeNext.addNextNode(key, value);
            } else {
                setRight(new Node<T1, T2>(key, value));
            }
        }
    }

//    ==========Getters============

    public T1 getKey() {
        return key;
    }

    public T2 getValue() {
        return value;
    }

    public Node<T1, T2> getLeft() {
        return left;
    }

    public Node<T1, T2> getRight() {
        return right;
    }

    public AtomicInteger getCount() {
        return count;
    }

//    ==========Setters=================

    public void setValue(T2 value) {
        this.value = value;
        count.incrementAndGet();
    }

    private void setLeft(Node<T1, T2> left) {
        this.left = left;
        print("Node::setLeft()::left = " + left);
    }

    private void setRight(Node<T1, T2> right) {
        this.right = right;
        print("Node::setRight()::right = " + right);
    }

    //    =======Utils Methods==========

    @SuppressWarnings("all")
    private void print(String msg) {

        boolean isAllowed = false;
//        boolean isAllowed = true;
        if (isAllowed) {
            System.out.println(msg);
        }
    }

}
