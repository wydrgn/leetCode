//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
// 请你实现这个将字符串进行指定行数变换的函数：
//
//
//string convert(string s, int numRows);
//
//
//
// 示例 1：
//
//
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
//
//示例 2：
//
//
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
//
//
// 示例 3：
//
//
//输入：s = "A", numRows = 1
//输出："A"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 由英文字母（小写和大写）、',' 和 '.' 组成
// 1 <= numRows <= 1000
//
// Related Topics 字符串
// 👍 1235 👎 0


package com.wydrgn.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class No6ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new No6ZigzagConversion().new Solution();
        String result = solution.convert("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 4);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //通过一个标记 循环将字符先正序再倒序再正序的方式插入numRows个数组中
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            List<StringBuilder> l = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                l.add(new StringBuilder());
            }
            int index = 0;// list下标
            int flag = -1;// 循环flag
            char[] chars = s.toCharArray();
            for (char c : s.toCharArray()) {
                l.get(index).append(c);
                if (index == 0 || index == numRows - 1) {//第一组和最后一组 反转flag
                    flag = -flag;
                }
                index += flag;
            }
            return l.stream().map(StringBuilder::toString).collect(Collectors.joining());
        }
        // my shit code
        /*public String convert(String s, int numRows) {
            //输入：s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", numRows = 4
            //numRows-1 + numRows-2
            //输出："PINALSIGYAHRPI"
            //解释：
            //A     G     M     S     Y    0  6  12 18 24
            //B   F H   L N   R T   X Z    1  5  7  11 13 17 19 23 25
            //C E   I  K  O  Q  U  W       2  4  8  10 14 16 20 22
            //D     J     P     V          3  9  15 21

            //A      I      Q      Y       0  8  16  24
            //B    H J    P R    X Z       1  7  9   15 17 23 25
            //C   G  K   O  S   W          2  6  10  14 18 22
            //D  F   L  N   T  V           3  5  11  13 19 21
            //E      M      U              4     12  20
            if (numRows == 1) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            int spaceNum = 2 * numRows - 3;
            for (int i = 0; i < numRows; i++) {
                int j = i;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    if (j % (spaceNum + 1) == 0 || j % (spaceNum + 1) == numRows - 1) {//第一行与最后一行
                        j += spaceNum + 1;
                    } else {

                    }
                }
            }
            return null;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
