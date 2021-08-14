package com.wydrgn.leetcode.editor.cn;

public class No4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new No4MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = new int[]{3};
        int[] nums2 = new int[]{-2,-1};
        solution.findMedianSortedArrays(nums1, nums2);
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

            return 0d;
        }

        // 合并2个数组后寻找中位数 时间复杂度 O(m+n) 空间复杂度O(m+n)
        /*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int MAX_INT = 2147483647;
            int[] resultNums = new int[nums1.length + nums2.length];
            if (nums2.length == 0 && nums1.length == 0) {
                return 0d;
            } else if (nums1.length == 0) {
                resultNums = nums2;
            } else if (nums2.length == 0) {
                resultNums = nums1;
            } else {
                int i = 0;
                int j = 0;
                int a = nums1[0];
                int b = nums2[0];
                for (int x = 0; x < resultNums.length; x++) {
                    if (a <= b) {
                        resultNums[x] = a;
                        if (i < nums1.length - 1) {
                            a = nums1[++i];
                        } else {
                            a = MAX_INT;
                        }
                    } else {
                        resultNums[x] = b;
                        if (j < nums2.length - 1) {
                            b = nums2[++j];
                        } else {
                            b = MAX_INT;
                        }
                    }
                }
            }
            double result = 0d;
            if (resultNums.length % 2 == 0) {
                result = (resultNums[resultNums.length / 2 - 1] + resultNums[resultNums.length / 2]) / 2.0;
            } else {
                result = resultNums[resultNums.length / 2];
            }
            return result;
        }*/

        /**
         * 归并排序
         *
         * @param nums 无序数组
         * @return
         */
        /*public int[] guibingpaixu(int[] nums) {
            nums = new int[]{1, 3, 9, 2, 4, 8, 5, 7, 6};
            int[] nums1 = new int[nums.length / 2];
            int[] nums2 = new int[nums.length - nums1.length];
            for (int i = 0; i < nums.length / 2; i++) {
                nums1[i] = nums[i];
                nums2[i] = nums[i + nums.length / 2];
            }
            if (nums.length % 2 != 0) {
                nums2[nums.length / 2] = nums[nums.length - 1];
            }
            int[] resultNums = rankByAsc(nums);
            System.out.println(resultNums);
            return resultNums;
        }*/

        /*private int[] rankByAsc(int[] nums) {
            int MAX_INT = 2147483647;
            int[] resultNums = new int[nums.length];
            if (nums.length > 1) {
                int[] nums1 = new int[nums.length / 2];
                int[] nums2 = new int[nums.length - nums1.length];
                for (int i = 0; i < nums.length / 2; i++) {
                    nums1[i] = nums[i];
                    nums2[i] = nums[i + nums.length / 2];
                }
                if (nums.length % 2 != 0) {
                    nums2[nums.length / 2] = nums[nums.length - 1];
                }
                nums1 = rankByAsc(nums1);
                nums2 = rankByAsc(nums2);
                int i = 0;
                int j = 0;
                int a = nums1[0];
                int b = nums2[0];
                for (int x = 0; x < resultNums.length; x++) {
                    if (a == -1) {
                        resultNums[x] = b;
                        if (j < nums2.length - 1) {
                            b = nums2[++j];
                        } else {
                            b = -1;
                        }
                    } else if (b == -1) {
                        resultNums[x] = a;
                        if (i < nums1.length - 1) {
                            a = nums1[++i];
                        } else {
                            a = -1;
                        }
                    } else if (a <= b) {
                        resultNums[x] = a;
                        if (i < nums1.length - 1) {
                            a = nums1[++i];
                        } else {
                            a = -1;
                        }
                    } else {
                        resultNums[x] = b;
                        if (j < nums2.length - 1) {
                            b = nums2[++j];
                        } else {
                            b = -1;
                        }
                    }
                }
            } else {
                resultNums = nums;
            }
            return resultNums;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}