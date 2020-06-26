/**
 * Given two arrays A and B, determine whether or not there exists a pair of elements, 
 * one drawn from each array, that sums to the given target number.
 *
 * Assumptions
 * The two given arrays are not null and have length of at least 1
 * 
 * Examples
 * A = {3, 1, 5}, B = {2, 8}, target = 7, return true(pick 5 from A and pick 2 from B)
 * A = {1, 3, 5}, B = {2, 8}, target = 6, return false
 */

public class 2SumTwoArrays {
    // 2 Sum: two pointers
    // Time: O(m + n), Space: O(1)
    public boolean existSum(int[] A, int[] B, int target) {
        // Assume A and B are not null and have length at leaste 2
        // Note A and B need to be both sorted!!
        Arrays.sort(A);
        Arrays.sort(B);
        int l = 0, r = B.length - 1;
        int res = A[l] + B[r];

        while (l < A.length && r >= 0) {
            int sum = A[l] + B[r];
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return false;
    }
}

/*
brutal force: 
    for-for loop, pick each element from A and B, check the 2 Sum
    time: O(n * m)
    space: O(1)
    
solution 2: 
    binary search, from each element in two inputs, find if there exists (T - A[i])
    time: O(n * logm) where A > B (m > n)
    space: O(1)

solution 2: 
    two pointers, from each element in two inputs, check the 2 Sum
    time: O(n + m) where A has size m, B has size n
    space: O(1)      
    
    A = [1  2  3  4  5  6]      if target = 9
         i ->     
    B = [5  6  7]      
            <- j  

本质: search in sorted matrix [每一行都是 sorted] [每一列都是 sorted]
往下走：i++;
往左走：j--;

       1  2  3  4     [i]++
    5 [6, 7, 8, 9]     |
    6 [7, 8, 9,10]
    7 [8, 9,10,11]

            <- [j]--
                      
可以从右上角 search (A[0], B[n - 1])
可以从左上角 search (A[m - 1], B[0])
*/
