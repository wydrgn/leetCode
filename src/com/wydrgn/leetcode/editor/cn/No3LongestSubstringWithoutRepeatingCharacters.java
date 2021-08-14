package com.wydrgn.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class No3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new No3LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "bdebaecf";
        solution.lengthOfLongestSubstring(s);
    }
    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4218 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLongestSubstring(String s) {
            Set<Character> sonStrSet = new HashSet<>();
            int maxSize = 0;
            int rightPoint = -1;
            for (int leftPoint = 0; leftPoint < s.length(); leftPoint++) {
                if (leftPoint != 0) {
                    sonStrSet.remove(s.charAt(leftPoint - 1));
                }
                while (rightPoint + 1 < s.length() && !sonStrSet.contains(s.charAt(rightPoint + 1))) {
                    sonStrSet.add(s.charAt(rightPoint + 1));
                    rightPoint++;
                }
                //sonStrSet.size() 这里用这个会多花一些时间
                maxSize = Math.max(maxSize, rightPoint - leftPoint + 1);
            }
            return maxSize;
        }

        /*public int lengthOfLongestSubstring(String s) {
            String[] arr = s.split("");
            String finalS = "";
            for (int i = 0; i < arr.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[i]);
                for (int j = i + 1; j < arr.length; j++) {
                    if (sb.toString().contains(arr[j])) {
                        break;
                    }
                    sb.append(arr[j]);
                }
                if (finalS.length() >= sb.toString().length()) {
                    continue;
                }
                finalS = sb.toString();
            }
            System.out.println(finalS.length());
            return finalS.length();
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}