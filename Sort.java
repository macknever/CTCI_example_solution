import java.util.Arrays;

public class Sort {
    // public int[] mergeSort(int[] nums) {
    // int len = nums.length;
    // if (len == 1) {
    // return nums;
    // }

    // int mid = len / 2;
    // int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
    // int[] right = mergeSort(Arrays.copyOfRange(nums, mid, len));

    // int l = left.length;
    // int r = right.length;

    // int lIndex = 0;
    // int rIndex = 0;
    // int index = 0;

    // int[] ans = new int[len];

    // while (lIndex < l && rIndex < r) {
    // if (left[lIndex] < right[rIndex]) {
    // ans[index++] = left[lIndex];
    // lIndex += 1;
    // } else {
    // ans[index++] = right[rIndex];
    // rIndex += 1;
    // }

    // }

    // if (lIndex == l) {
    // for (int i = rIndex; i < r; i++) {
    // ans[index++] = right[i];
    // }
    // } else if (rIndex == r) {
    // for (int j = lIndex; j < l; j++) {
    // ans[index++] = left[j];
    // }
    // }
    // return ans;

    // }

    public void bubbleSort(int[] nums) {
        boolean sorted = false;
        int len = nums.length;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < len - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    sorted = false;
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

    public void mergeS(int[] nums) {
        int len = nums.length;

        int[] helper = new int[len];
        mergeSort(nums, helper, 0, len - 1);
    }

    public void mergeSort(int[] nums, int[] helper, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (high + low) / 2;
        mergeSort(nums, helper, low, mid);
        mergeSort(nums, helper, mid + 1, high);
        merge(nums, helper, low, mid, high);
    }

    public void merge(int[] nums, int[] helper, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = nums[i];
        }

        int left = low;
        int right = mid + 1;
        int index = low;

        while (left <= mid && right <= high) {
            if (helper[left] < helper[right]) {
                nums[index++] = helper[left++];
            } else {
                nums[index++] = helper[right++];
            }
        }

        if (left <= mid) {
            for (int i = left; i <= mid; i++) {
                nums[index++] = helper[i];
            }
        }
    }

    public void quickSort(int[] nums) {
        int len = nums.length;
        quickSortHelper(nums, 0, len - 1);
    }

    public void quickSortHelper(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int start = left;
        int end = right;

        int pivot = nums[left];

        while (start < end) {
            while (end > start && nums[end] >= pivot) {
                end -= 1;
            }
            if (end > start) {
                nums[start] = nums[end];
                start += 1;
            }
            while (start < end && nums[start] <= pivot) {
                start += 1;
            }
            if (end > start) {
                nums[end] = nums[start];
                end -= 1;
            }
        }
        nums[start] = pivot;
        quickSortHelper(nums, left, start - 1);
        quickSortHelper(nums, start + 1, right);
    }

    public static void main(String[] args) {

        Sort sort = new Sort();
        int len = 9999;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = len - i;
        }
        int[] nums1 = Arrays.copyOf(nums, len);
        int[] nums2 = Arrays.copyOf(nums, len);
        int[] nums3 = Arrays.copyOf(nums, len);

        long start = System.nanoTime();
        sort.quickSort(nums1);
        long end = System.nanoTime();
        long time1 = end - start;

        start = System.nanoTime();
        sort.mergeS(nums2);
        end = System.nanoTime();
        long time2 = end - start;

        start = System.nanoTime();
        sort.bubbleSort(nums3);
        end = System.nanoTime();
        long time3 = end - start;

        // System.out.println("QuickSort result: " + Arrays.toString(nums1));
        // System.out.println("Merge result: " + Arrays.toString(nums2));
        // System.out.println("Bubble result: " + Arrays.toString(nums3));

        System.out.println("QuickSort runtime: " + time1);
        System.out.println("Merge runtime:     " + time2);
        System.out.println("Bubble runtime:    " + time3);

    }

}
