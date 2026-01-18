/*
 * Problem: Next Permutation
 * Platform: LeetCode
 * Difficulty: Medium
 *
 * Approach:
 * 1. Find the first decreasing element from the right.
 * 2. Swap it with the next greater element on the right.
 * 3. Reverse the remaining suffix.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        // Step 1: find first decreasing element
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: if no such element, reverse entire array
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: find next greater element and swap
        for (int j = n - 1; j > index; j--) {
            if (nums[j] > nums[index]) {
                swap(nums, j, index);
                break;
            }
        }

        // Step 4: reverse suffix
        reverse(nums, index + 1, n - 1);
    }
}
