package com.wydrgn.leetcode.editor.cn;

public class No4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new No4MedianOfTwoSortedArrays().new Solution();
        /*int[] nums1 = new int[]{1, 2, 4, 9, 15, 20, 21, 23};
        int[] nums2 = new int[]{3, 4, 6, 9, 20, 25, 27};*/
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
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

            // 判断中位数是奇数还是偶数
            boolean isEvenNum = (nums1.length + nums2.length) % 2 == 0; // false
            int index = (nums1.length + nums2.length) / 2; // 7
            int i = nums1.length - 1;
            int j = nums2.length - 1;
            int currentIndex = 0;
            while (currentIndex < index) {
                if (nums1[i] > nums2[j]) {
                    if (i != 1) {
                        i--;
                    }
                } else {
                    if (j != 1) {
                        j--;
                    }
                }
                currentIndex++;
            }
            if (isEvenNum) {
                int temp = 0;
                if (nums1[i] > nums2[j]) {
                    temp = nums1[i];
                    i--;
                } else {
                    temp = nums2[j];
                    j--;
                }
                return ((nums1[i] > nums1[j] ? nums1[i] : nums2[j]) + temp) / 2d;
            }
            return nums1[i] > nums1[j] ? nums1[i] : nums2[j];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
