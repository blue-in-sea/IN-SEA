/**
 * Define 95 Percentile: if we have 100 students taking a exam, the 95 percentile
 * of the score will be defined as: a score that is 
 * 1) 使得小于等于这个分数的人至少有95个
 * 2) 而且小于这个分数的人不到95个
 */

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
    // 物理意义: Find the minimum L such that at leaste 95% * n of the URLs have the length <= L
    
    public int percentile95(List<Integer> lengths) {
        // Assume input list is not null and has size >= 1 without any null values
        // The length of possible longest URL is 4096
        
        int[] count = new int[4097];
        // initialize count arr with all the frequency of the length of the URLs
        for (int len : lengths) {
            count[len]++;
        }
        
        int sum = 0;    // count total of URLs
        int len = 0;    // 初始化 if no element, L = 0  >= 0 * 0.95  will return 0
        // sum is the left area of how many URLs [.. 95% .. || L ....] that
        // has length <= L, sum has to be always smaller to 95% * n
        while (sum < 0.95 * lengths.size()) {
            len++;
            sum += count[len];
        }
        return len;
    }
}

/**
 * [在方法 2 里]
 * while (sum <= 0.95 * lengths.size()) {
 *      sum += count[len];
 *      len++;
 * }
 * 
 * input: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101]
 * output: 97
 * expected:<96> but was:<97>
 *
 * [在方法 2 里]
 * while (sum <= 0.95 * lengths.size()) {
 *      len++;
 *      sum += count[len];
 * }
 * sum <= 0.95 * lengths.size() 我们需要计算入 L 本身的数量, 违背了物理意义 [.. 95% .. || L ....]
 * input: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3]
 * output: 2
 * expected:<1> but was:<2>
 */

