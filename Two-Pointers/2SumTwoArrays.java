public class 2SumTwoArrays {
    // 2 Sum: two pointers
    // Time: O(m + n), Space: O(1)
    public boolean existSum(int[] A, int[] B, int target) {
        // Assume A and B are not null and have length at leaste 2
        // Note A and B need to be both sorted!!
        Arrays.sort(A);
        Arrays.sort(B);
        int l = 0, r = B.length - 1;
        int res = A[l] + B[r];

        while (l < A.length && r >= 0) {
            int sum = A[l] + B[r];
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return false;
    }
}
