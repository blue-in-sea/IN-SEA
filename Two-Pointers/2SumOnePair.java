public class 2SumOnePair {
    // 2 Sum: two pointer
    // Time: O(n), Space: O(1)
    public int[] twoSum(int[] array, int target) {
        // Assume the given array is not null, and has length at leaste 2
        // Assume array is sorted 
        int l = 0, r = array.length - 1;
        int res = array[l] + array[r];

        while (l < r) {
            int sum = array[l] + array[r];

            if (sum == target) {
                return new int[]{l + 1, r + 1};
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{-1, -1};
    }
}
