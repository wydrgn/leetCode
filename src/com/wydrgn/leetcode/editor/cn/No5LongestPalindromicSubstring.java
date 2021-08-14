package com.wydrgn.leetcode.editor.cn;

public class No5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new No5LongestPalindromicSubstring().new Solution();
        String result = solution.longestPalindrome("aba");
        System.out.println(result);
    }
    //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2626 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            /**
             * 动态规划思路(我自己想的):
             * 先寻找n=3的三位回文,标记中位下标index,并更新到resultStr 如果不存在就找n=2的回文
             * 存在则 n+2 根据下标判断是否仍为回文 为真则继续n+2 为假则删除下标index;
             */
            if (s != null && s.length() > 0) {
                String resultStr = "";
                if (s.length() >= 3) {
                    String[] arr = s.split("");
                    boolean isExist = true;
                    int size = 3;
                    while (isExist) {
                        String currentStr = "";
                        for (int i = 1; i < arr.length - 1; i++) {
                            // 这有问题!!!
                            if (arr[size / 2 - 1].equals(arr[size / 2 + 1])) {

                            }
                        }
                        if ("".equals(currentStr)) {
                            isExist = false;
                        }
                    }

                } else if (s.length() == 2) {
                    String[] arr = s.split("");
                    if (arr[0].equals(arr[1])) {
                        resultStr = s;
                    } else {
                        resultStr = arr[0];
                    }
                } else {
                    return s;
                }
                return resultStr;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}