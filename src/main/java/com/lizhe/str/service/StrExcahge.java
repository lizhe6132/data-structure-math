package com.lizhe.str.service;

/**
 * 给定一个字符串str和长度leftSize,请把str左侧leftSize的部分和右部分做整体交换，时间复杂度O(1)
 */
public class StrExcahge {
    /**
     * 方法一经典解法
     * 1，左侧部分逆序（左右指针）
     * 2，右侧部分逆序
     * 3，整体逆序
     * @param str
     * @param leftSize
     */
    public String headTailExcahge(String str, int leftSize) {
        char[] chars = str.toCharArray();
        // 左侧部分头尾交换
        int leftStart = 0;
        int rightStart = leftSize - 1;
        swap(chars, leftStart, rightStart);
        // 右侧部分头尾交换
        leftStart = leftSize;
        rightStart = chars.length -1;
        swap(chars, leftStart, rightStart);
        // 整体头尾交换
        leftStart = 0;
        rightStart = chars.length -1;
        swap(chars, leftStart, rightStart);
        return String.valueOf(chars);
    }

    private void swap(char[] chars, int leftStart, int rightStart) {
        char temp = 0;
        while (leftStart < rightStart) {
            temp = chars[leftStart];
            chars[leftStart++] = chars[rightStart];
            chars[rightStart--] = temp;
            /*leftStart++;
            rightStart--;*/
        }
    }

    /**
     * 方法二，少的部分和另一侧相同位数的交换后固定不动
     * 例如
     * str=abcdefgh,leftSize=5 目标 fghabcde
     * 1: 左侧abcde 右侧 fgh a与f交换 b与g交换 c与h交换 得 fghdeabc
     * 2:fgh固定不动 剩下的分为 左侧de 右侧abc 因为de在第一步并没有动而abc是换过来的
     * 3: 继续执行少的部分交换后然后不动的原则 d与b交换, e与c交换 得   fghbcade
     * 4：对bcade继续执行少的部分交换后然后不动的原则(de不动) 剩下的划分为 bc 和 a 两部分，（因为a上一步没动)
     * 5：对bca继续执行少的部分a交换后然后不动的原则 a与b交换 得 fghacbde
     * 6：剩下 cb,因为c上一步没动，c与b进行交换 得 fghabcde
     *
     * 此方法的优势是交换次数相对减少，极端情况下，若左右部分长度相等则仅需要交换N/2次
     * @param str
     * @param leftSize
     * @return
     */
    public String littleStandBy(String str, int leftSize) {
        char[] chars = str.toCharArray();
        int lPart = leftSize;
        int rPart = str.length() - leftSize;//右侧部分
        int same = Math.min(lPart, rPart); // 需要交换的长度(最小的长度需要交换)
        int l = 0; //左侧起始位置
        int r = str.length() -1; //右侧终止位置(一开始)
        int diff = lPart - rPart;
        excahge(chars, l, r, same);
        //划分子问题
        while (diff != 0) {
            if (diff > 0) {
                // 说明交换之前左边的长，交换到左侧的same长度的字符固定不动，则l应该又移same
                l+=same;
                lPart = diff;//新的左侧部分，右侧部分长度依旧没变
            } else {
                // 说明交换之前右边的长，交换到右侧的same长度的字符固定不动，则r应该左移same
                r-=same;
                rPart = -diff;
            }
            // 需要交换的长度
            same = Math.min(lPart, rPart);
            diff = lPart - rPart;
            excahge(chars, l, r, same);
        }
        return String.valueOf(chars);
    }

    private void excahge(char[] chars, int l, int r, int same) {
        int i = r - same + 1;
        char temp = 0;
        while (same-- != 0) {
            temp = chars[l];
            chars[l++] = chars[i];
            chars[i++] = temp;
        }
    }

    public static void main(String[] args) {
        StrExcahge excahge = new StrExcahge();
        String source = "abcdefgh";
        System.out.println(excahge.headTailExcahge(source, 4));
        System.out.println(excahge.littleStandBy(source, 4));
    }
}
