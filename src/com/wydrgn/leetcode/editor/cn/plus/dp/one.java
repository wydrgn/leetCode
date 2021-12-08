package com.wydrgn.leetcode.editor.cn.plus.dp;

/**
 * 动态规划 dynamic programming:1
 * 林宇翔提供的题目:
 * 给定一个全由小写字母组成的字符串,允许你至多删除掉其中3个字符,结果有多少种可能?
 * 输入: 长度[4,10^6]全小写英文字符串
 * 输出: 所有可能的结果的个数
 * 输入样例: "ababcc"
 * 输出样例: 25
 * 提示:
 * 删掉'0'个字符得到"ababcc"
 * 删掉'1'个字符得到["babcc","aabcc","abbcc","abacc","ababc"]
 * 删掉'2'个字符得到["abcc","bbcc","bacc","babc","aacc","aabb","abbc","abac","abab"]
 * 删掉'3'个字符得到["abc","bcc","acc","bbc","bac","bab","aac","aab","aba"]
 *
 * @author wydrgn
 * @date 2021/12/8 18:14
 */
public class one {

    public static void main(String[] args) {
        String str = "ababcc"; // a-z 26位
        int numberOfTime = 3;
        char[] chars = str.toCharArray();
        //4Byte,32byte
        byte[] myByte = new byte[4];

    }
}
