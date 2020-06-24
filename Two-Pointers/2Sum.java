// sol-1: use HashSet to store seen value
//        for a curr_value
//        check if we've seen (target - curr_value) 
// Time: O(n), Space: O(n)

// sol-2: use two-pointers 
//        check for all unique pairs (brutal force) -> O(n^2)    
//        sorted and search -> O(nlogn + n)

public class 2Sum {
    // Method 1: brutal force 
    // Time: O(n^2), Space: O(1)
    public boolean existSum(int[] array, int target) {
        for (int i = 0; i < array.length - 1; i++)  {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) return true;
            }
        }
        return false;
    }

    // Method 2: two pointers (space optimized if unsorted)
    // Time: O(nlogn + n), Space: O(1) for heap_sort 
    public boolean existSum(int[] array, int target) {
        // Assume the given array is not null, and has length at leaste 2
        Arrays.sort(array);
        
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == target) return true;
            else if (array[i] + array[j] < target) i++;
            else j--;
        }
        return false;
    }
    
    // Method 3: use HashSet to store seen value, and check for its complement
    // Time: O(n), Space: O(n) (time optimized)
    public boolean existSum(int[] array) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : array) {
            if (seen.contains(target - num)) return true;
            seen.add(num);
        }
        return false;
    }
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
