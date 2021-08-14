package com.wydrgn.leetcode.editor.cn;

public class No2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new No2AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode out = solution.addTwoNumbers(l1, l2);
        System.out.println(out);
    }
    //给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 != null && l2 != null) {
                int carry = 0;
                ListNode resultList = new ListNode(0);
                ListNode templist = resultList;
                while (l1 != null || l2 != null || carry == 1) {
                    int valOne = (l1 != null ? l1.val : 0);
                    int valTwo = (l2 != null ? l2.val : 0);
                    templist.next = new ListNode((valOne + valTwo + carry) % 10);
                    templist = templist.next;
                    carry = (valOne + valTwo + carry) > 9 ? 1 : 0;
                    if (l1 != null) l1 = l1.next;
                    if (l2 != null) l2 = l2.next;
                }
                return resultList.next;
            }
            return null;
        }

        /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode resultList = new ListNode(0);
            ListNode tempList = resultList;
            while (l1 != null && l2 != null) {
                tempList.next = new ListNode((l1.val + l2.val + carry) % 10);
                tempList = tempList.next;
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;

            }
            if (carry < 1) {
                if (l1 != null) {
                    tempList.next = l1;
                } else if (l2 != null) {
                    tempList.next = l2;
                }
            } else {
                while (l1 != null) {
                    tempList.next = new ListNode((l1.val + carry) % 10);
                    tempList = tempList.next;
                    carry = (l1.val + carry) / 10;
                    l1 = l1.next;
                }
                while (l2 != null) {
                    tempList.next = new ListNode((l2.val + carry) % 10);
                    tempList = tempList.next;
                    carry = (l2.val + carry) / 10;
                    l2 = l2.next;
                }
                if (carry > 0) {
                    tempList.next = new ListNode(1);
                }
            }
            return resultList.next;
        }*/
    }

    /**
     * 自定义链表
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}