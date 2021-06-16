
public class Search {

    // Consider an array of distinct numbers sorted in increasing order. The array
    // has been rotated (clockwise) k number of times. Given such an array, find the
    // value of k.

    // Input : arr[] = {15, 18, 2, 3, 6, 12}
    // Output: 2
    // Explanation : Initial array must be {2, 3,
    // 6, 12, 15, 18}. We get the given array after
    // rotating the initial array twice.

    // Input : arr[] = {7, 9, 11, 12, 5}
    // Output: 4

    // Input: arr[] = {7, 9, 11, 12, 15};
    // Output: 0

    public int searchRotation(int[] nums) {
        int len = nums.length;
        return searchRotationHelper(nums, 0, len - 1);
    }

    public int searchRotationHelper(int[] nums, int start, int end) {

        if (nums[end] > nums[start]) {
            return 0;
        }
        int mid = start + (end - start) / 2;

        if (mid < end && nums[mid] > nums[mid + 1]) {
            return mid + 1;
        }

        if (start < mid && nums[mid] < nums[mid - 1]) {
            return mid;
        }

        if (nums[start] < nums[mid]) {
            return searchRotationHelper(nums, mid + 1, end);
        }

        return searchRotationHelper(nums, start, mid - 1);
    }

    public boolean binarySearch(int[] nums, int target) {
        int len = nums.length;
        return binarySearchHelper(nums, target, 0, len - 1);
    }

    public boolean binarySearchHelper(int[] nums, int target, int start, int end) {

        if (start > end) {
            return false;
        }

        int mid = start + (end - start) / 2;

        if (target == nums[mid]) {
            return true;
        }

        if (target < nums[mid]) {
            return binarySearchHelper(nums, target, start, mid - 1);
        }

        return binarySearchHelper(nums, target, mid + 1, end);
    }

    public static void main(String[] args) {
        Search search = new Search();

        int nums[] = { 10, 2, 3, 4, 6, 7, 8, 9 };
        int ans = search.searchRotation(nums);
        System.out.println(ans);
        // int target = 4;
        // boolean result = search.binarySearch(nums, target);
        // System.out.println(result);
    }
}
