/*
 * Problem: Set Matrix Zeroes
 * Platform: LeetCode
 * Difficulty: Medium
 *
 * Approach:
 * Use a marker value to temporarily mark rows and columns
 * that need to be converted to zero.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(1)
 */

class Solution {

    private static final int MARKER = 1_000_000;

    private void markRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[row][col] != 0) {
                matrix[row][col] = MARKER;
            }
        }
    }

    private void markColumn(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] != 0) {
                matrix[row][col] = MARKER;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, i);
                    markColumn(matrix, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == MARKER) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
