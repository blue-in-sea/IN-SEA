public class CountOfSmallerNumbersAfterSelf {
    class SegTree {
        int n, k, m;
        int[] a;

        void resize(int size) {
            n = size;
            k = java.lang.Math.getExponent(size + 2) + 1;
            m = 1 << k;
            a = new int[m + m];
        }

        void addOne(int pos) {
            pos += m;
            ++a[pos];
            for (int i = pos >> 1; i >= 1; i >>= 1) {
                a[i] = a[i + 1] + a[i + i + 1];
            }
        }

        int query(int pos) {
            pos += m;
            int ans = 0;
            for (int i = pos; i != 1; i >>= 1) {
                if ((i & 1) != 0) {
                    ans += a[i - 1];
                }
            }

            return ans;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Collections.binarySearch(list, nums[i]);
        }
        
        SegTree segtree = new SegTree();
        segtree.resize(list.size());

        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            segtree.addOne(nums[i]);
            ans.add(segtree.query(nums[i]));
        }

        Collections.reverse(ans);
        return ans;
    }
}
