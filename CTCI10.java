import java.util.Arrays;
import java.util.*;

public class CTCI10 {
    // 10.1  
    // Sorted Merge: You are given two sorted arrays, A and B, where A has a large
    // enough buffer at the
    // end to hold B. Write a method to merge B into A in sorted order.
    /**
     * 
     * @param arrA
     * @param arrB
     * @param l
     */
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

    // 10.2 https://leetcode.com/problems/group-anagrams/
    // Write a method to sort an array of strings so that all the anagrams are next
    // to each other.

    // Example 1:

    // Input: strs = ["eat","tea","tan","ate","nat","bat"]
    // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public List<List<String>> GroupAnagrams(String[] words) {
        Map<String, List<String>> key2list = new HashMap<>();

        List<List<String>> ans = new ArrayList<>();

        for (String word : words) {
            String key = this.sortWord(word);
            List list = key2list.getOrDefault(key, new ArrayList<>());
            list.add(word);
            key2list.put(key, list);

        }

        for (String key : key2list.keySet()) {
            ans.add(key2list.get(key));
        }

        return ans;

    }

    // this helper function is to reorder the String to alphabet order
    public String sortWord(String word) {
        char[] helper = word.toCharArray();
        Arrays.sort(helper);

        return String.valueOf(helper);

    }

    public static void main(String[] args) {

        CTCI10 ctci = new CTCI10();

        // test 10.1
        int[] A = { 1, 2, 3, 4, 7, 9, 11, 0, 0, 0 };
        int[] B = { 6, 8, 10 };
        ctci.sortedMerget(A, B, 7);
        System.out.println(Arrays.toString(A));

        // test 10.2
        String[] testCase3 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> t = ctci.GroupAnagrams(testCase3);
        System.out.println(Arrays.toString(t.toArray()));
    }

}
