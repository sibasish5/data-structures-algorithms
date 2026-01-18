/*
 * Problem: Best Time to Buy and Sell Stock
 * Platform: LeetCode
 * Difficulty: Easy
 *
 * Approach:
 * Track the minimum buying price so far and calculate
 * the maximum profit at each step.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxProfit(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minBuyPrice = Math.min(minBuyPrice, price);
            maxProfit = Math.max(maxProfit, price - minBuyPrice);
        }
        return maxProfit;
    }
}
