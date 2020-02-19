package com.lizhe;


import com.lizhe.math.service.MathService;
import com.lizhe.math.service.impl.MathServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class TestCase {
    private  MathService mathService;
    @Before
    public void init() {
        mathService = new MathServiceImpl();
    }
    @Test
    public void testHw() {
        int x = 12121345;
        System.out.println(mathService.isHuiwen(x));
    }
    @Test
    public void testTwoSum() {
        //int[] nums = new int[]{2, 4,3, 5, 7, 8, 23, 45, 46, 38, 20, 16, 12, 17};
        int[] nums = new int[]{-1,-2,-3,-4,-5};
        int[] result = mathService.towSum(nums,   -8);
        for (int i =0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
