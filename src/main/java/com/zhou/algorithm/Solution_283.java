package com.zhou.algorithm;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_283 {
    public void moveZeroes(int[] nums) {
        // 1 循环迭代一遍，遇到0 不作为
        // 2. 遇到非0 元素向前移动直到 数组第一个元素的位置或遇到非0 元素为止

        int nonZerosIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZerosIndex] = nums[i];
                nonZerosIndex++;
            }
        }
        for (int j = nums.length - 1; j >= nonZerosIndex; j--) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        Solution_283 solution_283 = new Solution_283();
        solution_283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
