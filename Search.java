
public class Search {
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

        int nums[] = { 1, 2, 3, 4, 6, 7, 8, 9 };
        int target = 5;
        boolean result = search.binarySearch(nums, target);
        System.out.println(result);
    }
}
