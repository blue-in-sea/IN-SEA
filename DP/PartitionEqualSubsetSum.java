public class PartitionEqualSubsetSum {
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
}
