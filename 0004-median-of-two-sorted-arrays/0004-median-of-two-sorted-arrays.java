class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        int totalLeft = (m + n + 1) / 2;

        while (left <= right) {

            // Partition nums1
            int partition1 = left + (right - left) / 2;

            // Partition nums2
            int partition2 = totalLeft - partition1;

            // Values around partition1
            int nums1Left =
                    (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int nums1Right =
                    (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            // Values around partition2
            int nums2Left =
                    (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int nums2Right =
                    (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            // Correct partition
            if (nums1Left <= nums2Right &&
                nums2Left <= nums1Right) {

                // Odd total length
                if ((m + n) % 2 == 1) {

                    return Math.max(nums1Left, nums2Left);

                }

                // Even total length
                int leftMax = Math.max(nums1Left, nums2Left);
                int rightMin = Math.min(nums1Right, nums2Right);

                return (leftMax + rightMin) / 2.0;
            }

            // nums1 partition is too far right
            if (nums1Left > nums2Right) {
                right = partition1 - 1;
            }

            // nums1 partition is too far left
            else {
                left = partition1 + 1;
            }
        }

        return 0.0; // Should never be reached for valid input
    }
}