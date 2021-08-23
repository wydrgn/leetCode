package com.wydrgn.leetcode.editor.cn;

public class No4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new No4MedianOfTwoSortedArrays().new Solution();
        /*int[] nums1 = new int[]{1, 2, 4, 9, 15, 20, 21, 23};
        int[] nums2 = new int[]{3, 4, 6, 9, 20, 25, 27};*/
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3,4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
    //给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//
//
//
// 示例 1:
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
//
//
// 示例 2:
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
// Related Topics 数组 二分查找 分治算法
// 👍 3106 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 1 2 4 9 15 20 21 23
            // 3 4 6 9 20 25 27
            /**
             * 思路是 用两个指针来标记分别标记两个数组 首先是2个数组为正序 可以将数组两两左右分成两半
             * 当中位数偶数时,选取左数组最小值与右数组最大值相加除二即可或者中位数,奇数位时可以通过特殊设定左数组比右数组多一位 取左数组最大值即可
             * 同时也要处理极端情况的问题 比如
             * 1 2 3
             * 4 5 6 指针处于边界状态  需要控制数组下标防止出现负数或溢出的情况
             */
            if (nums1.length > nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }

            int m = nums1.length;
            int n = nums2.length;
            // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2; 注:-m是为了防止数值越界, +1是为了兼容奇数情况,左边数组比右边数组多一位,取左边最大作为中位数
            int totalLeft = (m + n + 1) / 2;
            // left ,right 为nums1的分割线 根据该分割线以及totalLeft可知nums2的分割线
            int left = 0;
            int right = m;
            // 满足条件 num1[top-1]<num2[bottom] && num2[bottom-1]<num1[top] 即nums1分割线左边最右参数应小于nums2分割线右边最左参数 && ...
            while (left < right) {
                int i = left + (right - left + 1) / 2;
                int j = totalLeft - i;
                if (nums1[i - 1] < nums2[j]) {
                    left = i;
                } else {
                    right = i - 1;
                }
            }
            int i = left;
            int j = totalLeft - left;
            int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMax = i == m ? Integer.MAX_VALUE : nums1[i];
            int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMax = j == n ? Integer.MAX_VALUE : nums2[j];

            // 判断中位数是否偶数
            // 这里用的黑科技是位运算
            // 判断一个数是否是2的n次方的方法，就是看这个数与这个数减一取与运算看是否是0，如果是，则是2的n次方，n为正整数。
            // 进一步的，奇偶性判断就是看对2取余是否为0，那么就相当于对（2-1）=1取与。
            boolean isEvenNum = ((nums1.length + nums2.length) & 1) == 0;
            if (isEvenNum) {
                return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMax, nums2RightMax)) * 1d / 2;
            }
            return Math.max(nums1LeftMax, nums2LeftMax);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
