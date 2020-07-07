public class Percentile95 {
    // Method-1: 从右往左 [.... L || .. 5% ..]
    // 物理意义: Find the maximum L such that at leaste 5% * n of the URLs have the length >= L
    
    public int percentile95(List<Integer> lengths) {
        // Assume input list is not null and has size >= 1 without any null values
        // The length of possible longest URL is 4096
        int[] count = new int[4097];
        // initialize count arr with all the frequency of the length of the URLs
        for (int len : lengths) {
            count[len]++;
        }

        int sum = 0;    // count total of URLs
        int len = 4097; // initialize max_len + 1
        // sum is the right area of how many URLs [.... L || .. 5% ..] that
        // has length >= L, sum has to be always smaller or equal to 5% * n
        while (sum <= 0.05 * lengths.size()) {
            len--;
            sum += count[len];
        }
        return len;
    }
    
    // Method-2: 从左到右 [.. 95% .. || L ....]
    // Find the maximum L such that at leaste 5% * n of the URLs
    // have the length >= L
    public int percentile95(List<Integer> lengths) {
        // Assume input list is not null and has size >= 1 without any null values
        // The length of possible longest URL is 4096
        int[] count = new int[4097];
        // initialize count arr with all the frequency of the length of the URLs
        for (int len : lengths) {
            count[len]++;
        }
        
        int sum = 0;    // count total of URLs
        int len = 0; // 初始化 if no element, L = 0  >= 0 * 0.95 
        // sum is the right area of how many URLs [.. 95% .. || L ....] that
        // has length >= L, sum has to be always smaller or equal to 5% * n
        while (sum < 0.95 * lengths.size()) {
            len++;
            sum += count[len];
        }
        return len;
    }
}
