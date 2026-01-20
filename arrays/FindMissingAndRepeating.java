/*
 * Problem: Find Missing and Repeating Number
 *
 * Given an array of size n containing numbers from 1 to n,
 * one number is missing and one number is repeated.
 *
 * Constraints:
 * - Do not modify the array
 * - O(n) time
 * - O(1) extra space
 */

class Solution {

    public int[] findMissingAndRepeating(int[] nums) {
        int n = nums.length;

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSqSum = (long) n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0;
        long actualSqSum = 0;

        for (int num : nums) {
            actualSum += num;
            actualSqSum += (long) num * num;
        }

        long diff = actualSum - expectedSum;           // A - B
        long sqDiff = actualSqSum - expectedSqSum;     // A^2 - B^2

        long sum = sqDiff / diff;                      // A + B

        int A = (int) ((diff + sum) / 2);              // Repeating
        int B = (int) (sum - A);                       // Missing

        return new int[]{A, B};
    }
}
