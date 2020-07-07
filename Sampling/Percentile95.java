public class Percentile95 {
    /**
     * Method-1: Find the maximum L such that at leaste 5% * n
     * of the URLs have the length >= L
     */
    public int percentile95(List<Integer> lengths) {
        // Assume input list is not null and has size >= 1 without any null values
        // The length of possible longest URL is 4096
        int[] count = new int[4097];
        // initialize count arr with all the frequency of the length of the URLs
        for (int len : lengths) {
            count[len]++;
        }
        // sum is the right area of how many URLs [.... L || .. 5% ..]
        // has length >= L, sum has to be always smaller or equal to 5% * n
        int sum = 0;
        int len = 4097;
        while (sum <= 0.05 * lengths.size()) {
            len--;
            sum += count[len];
        }
        return len;
    }
}
