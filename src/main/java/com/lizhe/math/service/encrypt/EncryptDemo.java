package com.lizhe.math.service.encrypt;

import com.lizhe.common.BCrypt;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptDemo {
    /**
     * 随机数生成密码
     */
    public void testSecureRandom() {
        SecureRandom random = new SecureRandom();
        // 用法1
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        System.out.println(Base64.getEncoder().encodeToString(bytes));

        // 用法2
        byte[] seed = random.generateSeed(16);
        System.out.println(Base64.getEncoder().encodeToString(seed));

    }

    /**
     * 专业密码算法,慢的刚刚好
     */
    public void testBCrypt() {
        String password = "asdf1234";
        // 第一次哈希一个password
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());//密文
        System.out.println(hashed);
        System.out.println(BCrypt.checkpw("4545565", hashed));
        String hashed2 = BCrypt.hashpw(password, BCrypt.gensalt(10));//密文
        System.out.println(hashed2);

    }

    public static void main(String[] args) {
        EncryptDemo ed = new EncryptDemo();
        /*for (int i =0 ; i < 10; i++) {
            ed.testSecureRandom();
        }*/
        ed.testBCrypt();
    }
}
