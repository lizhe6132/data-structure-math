package com.lizhe.str.service;

/**
 * 从一个字符串abbcdsedadbbdcsfgd中寻找abbcdd的字串下标（开始结束下标），不要求字串内字符的顺序,没有返回-1
 */
public class FindMaxChildStr {
    /**
     * 准备知识,怎么判断同源异构词
     * 两个字符串是否包含相同的字符及个数，顺序可以不一样(同源异构词)
     * @param str1
     * @param str2
     * acdd
     * int[a] 1
     * int[c] 1
     * int[d] 2
     *
     * cdda
     *
     * int[c] 0 (1--)
     * int[d] 0  (2-- 1   1--)
     * int[a] 0  (1--)
     *
     * 任何一个减之前==0都认为非法
     * @return
     */
    boolean is2StrEqual(String str1, String str2) {
        // 长度不相等的两个串肯定不是
        if (str1.length() != str2.length()) {
            return false;
        }
        // 创建一个256的int[],用于记录某个字符出现的次数
        int[] aimArr = new int[256];
        char[] str1Arr = str1.toCharArray();
        // 遍历str1 char数组，在相应的位置记录某个字符出现的次数
        for (int i = 0; i < str1Arr.length; i++) {
            aimArr[str1Arr[i]]++;
        }
        char[] str2Arr = str2.toCharArray();
        // 遍历str2 char数组，在相应位置将某个字符出现的次数减一
        // 如果减一之前是0,证明str1中该字符没有出现过或者出现的比str2中的少，此时返回false,不是同源异构词
        for (int i = 0; i < str2Arr.length; i++) {
            if (aimArr[str2Arr[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * 例如从一个字符串abbcdsedadbbdcsfgd中寻找abbcdd的字串下标（开始下标），不要求字串内字符的顺序,没有返回-1
     */
    public int findMaxChildStrIndex(String source, String aimStr) {
        if (source.length() < aimStr.length()) {
            return -1;
        }
        // 先获取目标aimStr所包含字符出现的次数作为判断依据
        int[] aimArr = new int[256];//负债表
        char[] aimChars = aimStr.toCharArray();
        for (int i = 0; i < aimChars.length; i++) {
            aimArr[aimChars[i]]++;
        }
        // 对source字符串进行窗口滑动(窗口大小aimStr.length)
        int m = aimChars.length;//窗口大小
        int invalidNum = 0;// 无效点数
        char[] strChars = source.toCharArray();
        int r = 0;
        // 第一个窗口
        for (;r < m; r++) {
            // 如果多还了一个字符，则无效点数+1
            if (aimArr[strChars[r]]-- <= 0) {
                invalidNum++;
            }
        }
        // 开始滑动窗口，窗口左出去一个，右进去一个
        for (;r < strChars.length; r++) {
            if (invalidNum == 0) {
                return r - m;
            }
            // 窗口右边进来一个字符(给负债表还字符)
            if (aimArr[strChars[r]]-- <= 0) {
                invalidNum++;
            }
            // 窗口左边出去一个字符(多还给负债表的字符出去)
            if (aimArr[strChars[r-m]]++ < 0) { //之所以<0就是因为我多还了
                invalidNum--;
            }
        }
        return invalidNum == 0 ? r - m : -1;
    }

    public static void main(String[] args) {
        FindMaxChildStr findMaxChildStr = new FindMaxChildStr();
        String str1 = "acdd";
        String str2 = "cdad";
        System.out.println(findMaxChildStr.is2StrEqual(str1, str2));
        String str3 = "abbcdsedadbbdcsfgd";
        String aimStr = "abbcdd";
        System.out.println(findMaxChildStr.findMaxChildStrIndex(str3, aimStr));
    }
}
