package com.lizhe.math.service;

public interface MathService {
    /**
     * 判断数字是否为回文
     * @param x
     * @return
     */
    boolean isHuiwen(int x);

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
     * @param nums
     * @param target
     * @return
     */
    int[] towSum(int[] nums, int target);
}
