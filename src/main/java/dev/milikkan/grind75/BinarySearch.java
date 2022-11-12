package dev.milikkan.grind75;

// problem link: https://leetcode.com/problems/binary-search/
public class BinarySearch {
    // time: O(log n)
    // space: O(1)
    public static int search(int[] nums, int target) {
        int minIndex = 0;
        int maxIndex = nums.length - 1;

        while (minIndex <= maxIndex) {
            int middleIndex = (maxIndex + minIndex) / 2;
            if (nums[middleIndex] == target) {
                return middleIndex;
            } else if (nums[middleIndex] < target) {
                minIndex = middleIndex + 1;
            } else {
                maxIndex = middleIndex - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 3, 5, 9, 12, 25, 63};
        int target1 = 25;

        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;

        int[] nums3 = {2, 5};
        int target3 = 2;

        int[] nums4 = {1};
        int target4 = 1;

        System.out.println(search(nums1, target1)); // 4
        System.out.println(search(nums2, target2)); // -1
        System.out.println(search(nums3, target3)); // 0
        System.out.println(search(nums4, target4)); // 0
    }
}
