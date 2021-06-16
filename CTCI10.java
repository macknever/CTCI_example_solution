import java.util.Arrays;

public class CTCI10 {
    public void sortedMerget(int[] arrA, int[] arrB, int l) {
        int lenA = arrA.length;
        int lenB = arrB.length;

        if (l + lenB != lenA) {
            return;
        }

        int index = lenA - 1;
        int i = l - 1;
        int j = lenB - 1;

        while (i >= 0 && j >= 0) {
            if (arrB[j] >= arrA[i]) {
                arrA[index] = arrB[j];
                j -= 1;
            } else {
                arrA[index] = arrA[i];
                i -= 1;
            }
            index -= 1;
        }
        if (i == -1) {
            while (j >= 0) {
                arrA[index--] = arrB[j--];
            }
        }
    }

    public static void main(String[] args) {
        CTCI10 ctci = new CTCI10();
        int[] A = { 1, 2, 3, 4, 7, 9, 11, 0, 0, 0 };
        int[] B = { 6, 8, 10 };
        ctci.sortedMerget(A, B, 7);
        System.out.println(Arrays.toString(A));
    }

}
