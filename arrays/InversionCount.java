/*
 * Problem: Count Inversions in an Array
 *
 * An inversion is a pair (i, j) such that:
 * i < j and nums[i] > nums[j]
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */

class Solution {

    public long countInversions(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private long mergeSort(int[] nums, int left, int right) {
        long count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            count += mergeSort(nums, left, mid);
            count += mergeSort(nums, mid + 1, right);
            count += merge(nums, left, mid, right);
        }

        return count;
    }

    private long merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;      // left subarray
        int j = mid + 1;   // right subarray
        int k = 0;
        long inversions = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                inversions += (mid - i + 1); // key step
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy back
        for (int x = 0; x < temp.length; x++) {
            nums[left + x] = temp[x];
        }

        return inversions;
    }
}
