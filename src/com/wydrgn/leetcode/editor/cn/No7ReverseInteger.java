//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [?2??, 231 ? 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//
//
//输入：x = -123
//输出：-321
//
//
// 示例 3：
//
//
//输入：x = 120
//输出：21
//
//
// 示例 4：
//
//
//输入：x = 0
//输出：0
//
//
//
//
// 提示：
//
//
// -2?? <= x <= 2?? - 1
//
// Related Topics 数学 ? 3020 ? 0


package com.wydrgn.leetcode.editor.cn;

public class No7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new No7ReverseInteger().new Solution();
        System.out.println(solution.reverse(123456));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 这个当然也不是我想到的思路 通过循环取余取最后一位 并将x除以10 直到x==0时退出循环
        // 注 因为此题不能使用long类型 所以需要提前判断最大值最小值是否会一出
        public int reverse(int x) {
            int result = 0;
            while (x != 0) {
                int temp = x % 10;
                // 溢出最大值
                if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && temp > Integer.MAX_VALUE % 10)) {
                    return 0;
                }
                // 溢出最小值
                if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && temp < Integer.MIN_VALUE % 10)) {
                    return 0;
                }
                x /= 10;
                result = result * 10 + temp;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
