// sol-1: use hashset to store seen value
//        for a curr_value
//        check if we've seen (target - curr_value) 
// Time: O(n), Space: O(n)

// sol-2: use two-pointers 
public class 2Sum {

}

/*
   0  1  2  3  4  5  6      if target = 9
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
                      
从右上角出发，拿 6 与 target 比较，可以知道是淘汰第一行，或者最后一行
--> Time: O(n) where n is # row/col or length of array
*/



