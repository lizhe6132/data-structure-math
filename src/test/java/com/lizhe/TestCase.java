package com.lizhe;


import com.lizhe.math.service.MathService;
import com.lizhe.math.service.impl.MathServiceImpl;
import org.junit.Test;

import java.util.Scanner;

public class TestCase {
    @Test
    public void testHw() {
        MathService mathService = new MathServiceImpl();
        int x = 12121345;
        System.out.println(mathService.isHuiwen(x));
    }
}
