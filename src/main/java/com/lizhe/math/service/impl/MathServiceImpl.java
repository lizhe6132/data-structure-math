package com.lizhe.math.service.impl;

import com.lizhe.math.service.MathService;

import java.util.HashMap;
import java.util.Map;

public class MathServiceImpl implements MathService {
    @Override
    public boolean isHuiwen(int x) {
        /**
         * 负数和末尾是0的肯定不是回文
         */
        if (x < 0 || (x % 10 == 0 && x != 0)) {return false;}
        /**
         * 对折一半比较
         */
        int revertedNumber = 0;
        // 对折
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 偶数位与奇数位不同
        //例如1221的分解过程 122 12
        //                   1   12
        // 此时比较是否相等
        // 1224221分解过程 122422 12242 1224 122
        //                      1    12  122 1224
        return x == revertedNumber || x == revertedNumber / 10;
    }

    @Override
    public int[] towSum(int[] nums, int target) {
        // 递归
        //int[] result = findDes(nums, 0, target);
        //return result;
        // 暴力循环
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public int[] findDes(int[] nums, int i, int target) {
        int[] result = new int[2];
        result[0] = i;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                result[1] = j;
                return result;
            } else {
                if (j == nums.length - 1) {
                    return findDes(nums, i + 1, target);
                }
            }
        }
        return result;
    }
}
