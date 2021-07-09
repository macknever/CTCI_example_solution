# Eaxmples and Solutions

## 1. Sorting and Searching

### Quick Sort

- randomly choose a pivot, seperate the array into LEFT and RIGHT

- items which are less than pivot, put in LEFT

- items which are greater than pivot, put in RIGHT

- Quick sort LEFT

- Quick sort RIGHT

  [![Quick Sort](https://img.youtube.com/vi/Fnpa1KtwJsA/0.jpg)](https://www.youtube.com/watch?v=Fnpa1KtwJsA "Quick Sort")

### Merge Sort

- If only one item, DONE;

- Separate original array into two part, LEFT(0 ~ mid), RIGHT(mid ~ end)

- Merge Sort LEFT

- Merge Sort RIGHT

  // right now, LEFT and RIGHT are both sorted

- compare the first uncompared the items from LEFT and RIGHT, pick the small one insert to the result array.

- There should be remaining items in LEFT or RIGHT, put all of them in the end of result array.

### Binary Search

Easy but useful algorithm. Searching target value from a sorted array

- Compare target with mid of the array
- if equals. DONE
- if less. Binary Search left part.
- if greater. Binary Search right part.



### Interview Questions

1.   **Sorted Merge**: Given two sorted arrays, A and B, where A has a large enough buffer at the

   end to hold B. Write a method to merge B into A in sorted order.

   - Solution

     Comparing the last element of A and B, choose the larger one and insert it to the <u>*end*</u> of A

     [10.2](CTCI10.java)

   

