package com.sorts;

/**
 * @author stalwarthuang
 * @since 2025-04-03 星期四 23:25:18
 */
public class qsort {
    public static void main(String[] args) {
        int[] nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        qsort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    static void qsort(int[] nums, int left, int right) {
        if (left < right) {
            int n = get(nums, left, right);
            qsort(nums, left, n - 1);
            qsort(nums, n + 1, right);
        }
    }

    static int get(int[] nums, int l, int r) {
        int left = l;
        int right = r;
        int mid = nums[left];
        while (left < right) {
            while (left < right && mid <= nums[right])
                right--;
            nums[left] = nums[right];
            while (left < right && mid >= nums[left])
                left++;
            nums[right] = nums[left];
        }
        nums[left] = mid;
        return left;
    }
}
