package com.lizhe.stackandqueue;

import java.util.Stack;

/**
 * 实现一个栈，在实现栈的基本功能外，再实现获取栈中最小元素getMin功能
 */
public class MyStackWithGetMin {
    //正常栈，实现栈的基本功能
    private Stack<Integer> stackData;
    // 记录最小值的栈，其栈顶元素是stackData中元素最小的
    private Stack<Integer> stackMin;

    public MyStackWithGetMin(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(Integer value) {
        stackData.push(value);
        // 如果stackMin为空则也压入此元素
        if (stackMin.isEmpty()) {
            stackMin.push(value);
            //比较当前压栈的值和stackMinValue的大小，如果小于等于stackMinValue，则stackMin也压入此元素，否则不压入
        } else if (value <= getMin()) {
            stackMin.push(value);
        }

    }

    /**
     * 出栈，判断出栈元素与stackMin栈顶元素的大小
     * 若等于stackMin栈顶元素，则stackMin也出栈，说明最小值已经被取走了
     * 若大于stackMin栈顶元素，则直接将此值返回，说明弹出去的不是当前的最小值
     * 最小值依然由stackMin的栈顶元素持有
     * @return
     */
    public Integer pop() {
        if (stackData.isEmpty()) {
            throw new IllegalStateException("there is no any element in this stack");
        }
        Integer resultVal = stackData.pop();
        if (resultVal == getMin()) {
            stackMin.pop();
        }
        return resultVal;

    }
    public Integer getMin() {
        //stackMin的栈顶元素是最小的
        if (stackMin.isEmpty()) {
            throw new IllegalStateException("there is no any element in this stack");
        }
        return stackMin.peek();
    }
    public boolean isEmpty() {
        return stackData.isEmpty();
    }
}
