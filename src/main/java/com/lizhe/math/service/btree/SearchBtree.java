package com.lizhe.math.service.btree;

/**
 * 搜索二叉树 左边的小，右边的大
 *        5
 *    3      7
 *  2   4  6    8
 *
 * 后序遍历即按左 --右 - 头顺序遍历 2,4,3,6,8,7,5
 */
public class SearchBtree {
    /**
     * 已知一个搜素二叉树后序遍历的数组postArr
     * 请根据postArr重建整棵树，将头结点返回
     */
    public int rebuildBTree(Integer[] postArr) {
        return postArr[postArr.length - 1];
    }
}
