/*
 * Problem: Merge Intervals
 * Platform: LeetCode
 * Difficulty: Medium
 *
 * Approach:
 * 1. Sort intervals based on start time.
 * 2. Merge overlapping intervals by comparing with last merged interval.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return new int[0][0];

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // If no overlap, add interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < intervals[i][0]) {
                merged.add(intervals[i]);
            } 
            // If overlap, merge intervals
            else {
                merged.get(merged.size() - 1)[1] =
                        Math.max(merged.get(merged.size() - 1)[1], intervals[i][1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
