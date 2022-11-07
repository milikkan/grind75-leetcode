package dev.milikkan.grind75;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
    // time: O(n)
    // space: O(n)
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> found = new HashMap<>();

        for (int idx = 0; idx < nums.length; idx++) {
            int current = nums[idx];
            int lookingFor = target - current;
            if (found.containsKey(lookingFor)) {
                return new int[]{idx, found.get(lookingFor)};
            }
            found.put(current, idx);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        for (int num : twoSum(nums1, target1)) System.out.print(num + " ");
        System.out.println();

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        for (int num : twoSum(nums2, target2)) System.out.print(num + " ");
        System.out.println();

        int[] nums3 = {3, 3, 3, 2};
        int target3 = 5;
        for (int num : twoSum(nums3, target3)) System.out.print(num + " ");
        System.out.println();
    }
}
