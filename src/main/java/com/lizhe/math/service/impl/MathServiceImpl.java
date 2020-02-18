package com.lizhe.math.service.impl;

import com.lizhe.math.service.MathService;

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
}
