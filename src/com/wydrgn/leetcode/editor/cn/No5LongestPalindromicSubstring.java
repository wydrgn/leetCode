package com.wydrgn.leetcode.editor.cn;

public class No5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new No5LongestPalindromicSubstring().new Solution();
        String result = solution.longestPalindrome("aabbccbbad");
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
//e
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
// 👍 2626 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 存在缺陷 比如最长回文是5位 但是因为4位找不到回文 二分查找会漏掉5位的结果
         * 我的思路 优化? 用二分法 寻找最长回文
         * shit code
         */
        /*public String longestPalindrome(String s) {
            String pal = "";
            int left = 0;
            int right = s.length();
            while (left < right) {
                int palindromeLength = (left + right + 1) / 2;
                boolean isPal = true;
                for (int i = 0; i <= s.length() - palindromeLength; i++) {
                    isPal = true;
                    int begin = i;
                    int end = i + palindromeLength - 1;
                    while (end > begin) {
                        if (s.charAt(begin) == s.charAt(end)) {
                            begin += 1;
                            end -= 1;
                        } else {
                            isPal = false;
                            break;
                        }
                    }
                    String currentPal = s.substring(i, i + palindromeLength);
                    System.out.println(currentPal);
                    if (isPal && pal.length() < currentPal.length()) {
                        pal = currentPal;
                        System.out.println("记录当前" + currentPal + "为新的回文啦");
                    }
                }
                if (isPal) { // 存在回文 接着找更长的回文
                    left = palindromeLength;
                } else { // 反之

                    right = palindromeLength - 1;
                }
            }
            return pal;
        }*/

        /**
         * 动态规划
         * 时间复杂度 O(n^2)
         * 空间复杂度
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s.length() <= 2) {
                return s;
            }
            // 字符串长度
            int length = s.length();
            // 最长回文长度
            int maxlength = 0;
            // 回文启示下标
            int begin = 0;
            // dp[i][j]表示 s.substring(i,j-i)是否为回文
            boolean[][] dp = new boolean[length][length];
            // dp[x][x] 表示自身一定为回文
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
            }
            // 注 我发现动态规划必须满足一定的套娃和可拆解 比如下条件
            // 满足条件 dp[i][j] = (s[i]==s[j]) && ( j-i <3 or dp[i+1][j-1])
            char[] charArray = s.toCharArray();

            return null;
        }

        public boolean comparing(int i, int j) {

            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
