package com.lizhe.stackandqueue;

import java.util.Stack;

/**
 * 仅用递归实现栈的逆序
 */
public class ReversStackInRecursion {

    public int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
}
