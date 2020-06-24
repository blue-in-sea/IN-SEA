public class LongestSubarrayContainsOnly1s {
    // Time: O(n) since left and right each move n times during the sliding window
    // Space: O(1)
    public int longestOnes(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= k) {
            return nums.length;
        }
        
        // sliding window : [l, r] used as much as k flips
        int cntZero = 0;
        int res = 0;

        for (int l = 0, r = 0; l < nums.length; l++) {
            while (r < nums.length) {
                if (nums[r] == 1) {
                    res = Math.max(res, r - l + 1);
                    r++;
                } else if (cntZero < k) {
                    cntZero++;
                    res = Math.max(res, r - l + 1);
                    r++;
                } else {
                    break;
                }
            }

            if (nums[l] == 0) {
                cntZero--;
            }
        }

        return res;
    }
}
