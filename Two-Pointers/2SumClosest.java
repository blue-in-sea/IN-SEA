/**
 * Find the pair of elements in a given array that sum to a value that is closest to the given target number. 
 * Return the values of the two numbers.
 */

public class 2SumClosest {
    // two pointers: search in sorted matrix
    // time: O(nlogn) + O(n)
    // space: O(1) in case of heap sort 
    
    public List<Integer> closest(int[] array, int target) {
        // Assume the given array is not not and has len of at leaste 2
        Arrays.sort(array);
        
        int l = 0, r = array.length - 1;
        int res = array[l] + array[r];
 
        List<Integer> pair = Arrays.asList(array[l], array[r]);
        while (l < r) {
            int sum = array[l] + array[r];
            
            // update the result sum
            if (Math.abs(target - sum) < Math.abs(target - res)) {
                res = array[l] + array[r];
                pair = Arrays.asList(array[l], array[r]);
            }
            
            // two pointers
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return pair;
            }
        }
        
        return pair;
    }
}
