public class 4Sum {
    // Method 1: sort the array first, then apply 3 Sum to check 
    // if there exist an A[i] such that A[i] + 3Sum == target?
    
    // Time: O(n^3) for 3 Sum is O(n^2) and we need one more iteration
    // Space: O(1) no extra space used 
    public boolean exist(int[] array, int target) {
        // Assume array is not null and has length at leaste 4
        Arrays.sort(array);
        
        for (int i = 0; i < array.length; i++) {
            
            for (int j = i + 1; j < array.length; j++) {
                int left = j + 1;
                int right = array.length - 1;
                int currTarget = target - array[i] - array[j];

                while (left < right) {
                    int sum = array[left] + array[right];
                    if (sum == currTarget) {
                        return true;
                    }
                    
                    if (sum < currTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
      
        }
        
        return false;
  }
}
