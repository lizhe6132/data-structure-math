package com.lizhe.stackandqueue;

import java.util.Stack;

/**
 * 用两个栈实现队列，实现队列基本操作poll,add,peek
 * stackPush --> stackPop
 * 注意:
 * 1,stackPop为空时才能push --> pop
 * 2, push --> pop stackPush要一次倒完
 */
public class TwoStacksQueue {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    /**
     * 将stackPush中的元素倒入stackPop中，必须每次倒完
     * 倒入前stackPop必须为空
     */
    public void push2pop() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }
    public void add(Integer value) {
        stackPush.push(value);
        push2pop();
    }
    public Integer poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        push2pop();
        return stackPop.pop();
    }
    public Integer peek() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        push2pop();
        return stackPop.peek();
    }

}
