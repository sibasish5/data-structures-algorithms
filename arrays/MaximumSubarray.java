/*
 * Problem: Maximum Subarray
 * Platform: LeetCode
 * Difficulty: Easy
 *
 * Approach:
 * Kadane's Algorithm – keep track of the current subarray sum
 * and reset it when it becomes negative.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
