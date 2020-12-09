package com.lizhe.tree;

/**
 * @Author: lizhe
 * @Date: created in 2020/12/9 9:38
 * @Description:
 */
public class Node {
    private int value;
    private Node left;
    private Node right;

    public int value() {
        return value;
    }
    public Node left() {
        return left;
    }
    public Node right() {
        return right;
    }
    public void value(int value) {
        this.value = value;
    }
    public void left(Node node) {
        this.left = node;
    }
    public void right(Node node) {
        this.right = node;
    }
}
