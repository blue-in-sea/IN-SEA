public class 2SumSmaller {
    public int smallerPairs(int[] array, int target) {
        // Assume array is not null and has length of at least 2
        Arrays.sort(array);
        
        int i = 0, j = array.length - 1;
        int res = 0;
        
        while (i < j) {
            if (array[i] + array[j] < target) {
                res += (j - i);
                i++;
            } else {
                j--;
            }
        }
        
        return res;
    }
}

/*
A[i] = {0  1  2  3  4  5  6}, target = 9, find the number of pairs that smaller than target
Assume the input array is not null, and has length at leaste 1
Assume duplicates exist 

   0  1  2  3  4  5  6      
   i ->           <- j

本质: search in sorted matrix [每一行都是 sorted] [每一列都是 sorted]
往下走：i++;
往左走：j--;

       0  1  2  3  4  5  6     [i]++
    0 [0, 1, 2, 3, 4, 5, 6]     |
    1 [1, 2, 3, 4, 5, 6, 7]
    2 [2, 3, 4, 5, 6, 7, 8]
    3 [3, 4, 5, 6, 7, 8, 9]  
    4 [4, 5, 6, 7, 8, 9,10]   
    5 [5, 6, 7, 8, 9,10,11]  

                      <- [j]--
                      
step-1: starting from (0, 6) the top-right corner (where i = 0, j = lenArr - 1) 
step-2: value = 6 < target = 9, 
          res += 6 (j - i) then 
          go down on row (i++)

[note]: if the top-right value >= target
          那么最后一列都不会有 target
          可以直接 go right (j--)
*/


/*

从右上角出发，拿 6 与 target 比较，可以知道是淘汰第一行，或者最后一行
--> Time: O(n) where n is # row/col or length of array
*/


