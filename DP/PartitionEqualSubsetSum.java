public class PartitionEqualSubsetSum {
    // M1: DFS
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        Arrays.sort(nums);
        return dfs(nums, 0, sum / 2);
    }

    private boolean dfs(int[] nums, int index, int target) {
        if (target == 0) return true;
        if (index == nums.length || target < 0) return false;

        if (dfs(nums, index + 1, target - nums[index])) {
            return true;
        }
        // 如果不加，就再也不加进来了
        int j = index + 1;
        while (j < nums.length && nums[index] == nums[j]) {
            j++;
        }
        return dfs(nums, j, target);
    }
    
    // M2: DP I
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 && j > 0) {
                    dp[i][j] = nums[i] == j;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    // 不放
                    dp[i][j] = dp[i - 1][j];
                    // 放
                    if (j - nums[i] >= 0) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i]];
                    }
                }
            }
        }

        return dp[nums.length - 1][target];
    }
    
    // M3: DP II
}
