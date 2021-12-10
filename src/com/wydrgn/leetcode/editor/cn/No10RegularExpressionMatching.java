//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//
// '.' 匹配任意单个字符
// '*' 匹配零个或多个前面的那一个元素
//
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
//
// 示例 1：
//
//
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
//
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3：
//
//
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4：
//
//
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5：
//
//
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false
//
//
//
// 提示：
//
//
// 0 <= s.length <= 20
// 0 <= p.length <= 30
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
// 保证每次出现字符 * 时，前面都匹配到有效的字符
//
// Related Topics 递归 字符串 动态规划 👍 2326 👎 0


package com.wydrgn.leetcode.editor.cn;

public class No10RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new No10RegularExpressionMatching().new Solution();
        solution.isMatch("aab", "c*a*b");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            // 练习题
            // https://alchemist-al.com/algorithms/regular-expression-matching
            int sLength = s.length();
            int pLength = p.length();
            boolean[][] f = new boolean[sLength + 1][pLength + 1];

            // 特殊情况
            f[0][0] = true;
            for (int i = 0; i <= sLength; i++) {
                for (int j = 1; j <= pLength; j++) {
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];// 因为*号一定只会从第二位元素开始,即j=2 这里不会有问题
                        if (matches(s, p, i, j - 1)) { // 如果match '*'前一位字母 则说明有可能符合 X*
                            f[i][j] = f[i][j] || f[i - 1][j]; // 比较前j-1位的p与s true 则当前也为true 因为*可表示多个或一个字母X
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
            return f[sLength][pLength];
        }

        public boolean matches(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
