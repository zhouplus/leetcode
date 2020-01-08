package com.zhou.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution001 {

    /**
     * 求两数之和为target的值的下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = null;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            //比目标值大的都去掉
            // 用 map 来记录下标
            if (map.containsKey(nums[i]) && (nums[i] * 2 == target)) {
                result = new int[2];
                result[0] = map.get(nums[i]);
                result[1] = i;
                sortIntValue(result);
                return result;
            }
            map.put(nums[i], i);

        }
        Set<Integer> set = map.keySet();
        for (int tem : set) {
            int temSide = target - tem;
            if (set.contains(temSide)) {
                result = new int[2];
                result[0] = map.get(tem);
                result[1] = map.get(temSide);
                //下标排序
                sortIntValue(result);
                return result;
            }
        }
        return result;
    }

    private void sortIntValue(int[] result) {
        if (result[0] > result[1]) {
            int tt = result[0];
            result[0] = result[1];
            result[1] = tt;
        }
    }


    public static void main(String[] args) {
        Solution001 solution = new Solution001();

        int[] nums = new int[]{230,863,916,585,981,404,316,785,88,12,
                                70,435,384,778,887,755,740,337,86,92,
                                325,422,815,650,920,125,277,336,221,847,
                                168,23,677,61,400,136,874,363,394,199,
                                863,997,794,587,124,321,212,957,764,173,
                314,422,927,783,930,282,306,506,44,926,
                691,568,68,730,933,737,531,180,414,751,
                28,546,60,371,493,370,527,387,43,541,
                13,457,328,227,652,365,430,803,59,858,
                538,427,583,368,375,173,809,896,370,789};
        int target = 542;
        int[] ret = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ret));
        //28,45
        //221
        //282
    }


}
