/*
 * Problem: Find the Duplicate Number
 * Platform: LeetCode
 * Difficulty: Medium
 *
 * Approach:
 * Floyd’s Tortoise and Hare (Cycle Detection).
 *
 * Treat the array as a linked list where:
 * index -> nums[index]
 * The duplicate number creates a cycle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find cycle entrance
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
