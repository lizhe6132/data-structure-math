package com.lizhe.tree;

import java.util.Stack;

/**
 * @Author: lizhe
 * @Date: created in 2020/12/9 9:35
 * @Description: 二叉树经典算法 要拿子树就拿完，不允许拿一半
 *                     1
 *                 2       3
 *              4    5   6   7
 * 先序遍历 中-左子树-右子树 1 2 4 5 3 6 7
 * 中序遍历 左子树-中-右子树 4 2 5 1 6 3 7
 * 后序遍历 左子树-右子树-中 4 5 2 6 7 3 1
 *
 */
public class BinaryTreeDemo {
    /**
     * 递归先序
     */
    public void pre(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value());
        pre(node.left());
        pre(node.right());
    }

    /**
     * 递归中序
     * @param node
     */
    public void in(Node node) {
        if (node == null) {
            return;
        }
        in(node.left());
        System.out.print(node.value());
        in(node.right());
    }

    /**
     * 递归后序
     * @param node
     */
    public void post(Node node) {
        if (node == null) {
            return;
        }
        post(node.left());
        post(node.right());
        System.out.print(node.value());
    }
    // 仔细观察上面的三个方法，处理逻辑很类似，只是打印的时机不一样
    // 其实对于每一个节点 都有 自己的值，左子树 ，右子树，只不过最后的叶子上的子树都为null\
    // null也是有东西的，因此我们把一般规律抽象出来便有:
    // 任何一个节点我们都找了它自己，并且找了它的左子树，并且还找了它的右子树
    // 若子树有子树则继续找，若子树为null则向上返回，这样每个节点被访问的次数是3次
    // 可以总结为 我自己的节点，处理我的左子树，处理我的右子树，碰到null则返回
    // 前序遍历即我自己第一次出现就打印，中序遍历就我自己第二次出现就打印,后序即我自己第三次出现就打印
    // 以前序遍历示例: 1 我自己出现了第一次打印 找我的左子树2(对于2来说也第一次出现也打印) 2找它自己的子树
    // 4 (4找它的左子树为null返回4,4出现了第二次)4 继续找右子树为null 返回4节点,4第三次出现，依次类推
    //最终各节点出现的次数为
    // 124442555213666377731
    //则前序遍历为第一次出现就打印，很容易得到结果1245367
    // 中序遍历为第二次出现就打印，很容易得到结果4251637
    // 后序遍历为第三次出现就打印，很容易得到结果4526731
    // *****这就是普遍的二叉树遍历规律**********

    /**
     * 普遍二叉树遍历规律
     */
    public void generic(Node node) {
        if (node == null) {
            return;
        }
        //前序
        //System.out.print(node.value());
        // 处理我的左子树
        generic(node.left());
        // 中序
        //System.out.print(node.value());
        // 处理我的右子树
        generic(node.right());
        // 后序
        System.out.print(node.value());
    }
    // 接下来用非递归方式处理
    // 任何递归都可以转为非递归，用栈处理

    /**
     * 前序遍历用栈实现非递归
     * 思路:
     * 1,首先创建栈然后压入根节点
     * 2，当栈不为空时循环
     * 3，弹出即打印
     * 4，右子树压入栈
     * 5，左子树压入栈
     * @param head
     */
    public void preStack(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value() + "");
            if (head.right() != null) {
                stack.push(head.right());
            }
            if (head.left() != null) {
                stack.push(head.left());
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历栈实现非递归
     * 思路:
     * 前序的处理思路一样，只是先压入左子树，再压入右子树 结果为 中--右--左
     * 然后不打印存入另外一个栈实现倒序结果即为左--右--中，即后序
     * @param head
     */
    public void postStack(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Stack<Node> resultCollect = new Stack<>();
        while (!stack.isEmpty()) {
            head = stack.pop();
            resultCollect.push(head);
            if (head.left() != null) {
                stack.push(head.left());
            }
            if (head.right() != null) {
                stack.push(head.right());
            }
        }
        // 输出结果
        while (!resultCollect.isEmpty()) {
            System.out.print(resultCollect.pop().value() + "");
        }
        System.out.println();

    }

    /**
     * 中序遍历栈实现非递归
     * 思路:
     * 栈不为空或者head !=null
     * * 1 将左子树压入栈
     * 2 直到左子树为null 弹出节点打印，开始处理弹出节点的右子树(依旧将右子树的所有左子树压入栈)
     * @param head
     */
    public void inStack(Node head) {
        if (head == null) {
            return;
        }
        // 准备一个栈
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left();
            } else {
                head = stack.pop();
                System.out.print(head.value() + "");
                head = head.right();
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.value(1);
        Node node2 = new Node();
        node2.value(2);
        Node node3 = new Node();
        node3.value(3);
        node1.left(node2);
        node1.right(node3);
        Node node4 = new Node();
        node4.value(4);
        Node node5 = new Node();
        node5.value(5);
        node2.left(node4);
        node2.right(node5);
        Node node6 = new Node();
        node6.value(6);
        Node node7 = new Node();
        node7.value(7);
        node3.left(node6);
        node3.right(node7);
        BinaryTreeDemo demo = new BinaryTreeDemo();
       /* // 先序
        demo.pre(node1);
        System.out.println();
        // 中序
        demo.in(node1);
        System.out.println();
        // 后序
        demo.post(node1);
        System.out.println();*/
       /*demo.generic(node1);
       System.out.println();*/
       demo.preStack(node1);
       demo.postStack(node1);
       demo.inStack(node1);

    }
}
