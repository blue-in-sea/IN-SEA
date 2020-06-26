/**
 * Given a binary search tree and a target number, find out whether there are a pair of TreeNodes that 
 * the sum of their values equals to the given target.
 */

public class 2SumBST {
    // inorder traversal convert the BST into a sorted list (ascending) 
    // + two pointer (i, j) begins from the start and end (a 2-sum way)
    // Time: O(n), Space O(h + n) => O(n)
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);

        int i = 0, j = arr.size() - 1;
        while (i < j){
            int sum = arr.get(i) + arr.get(j);
            if(sum == k) {
                return true;
            }
            // 2 Sum
            if(sum < k) {
                i++;
            } else{
                j--;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> arr) {
        if (root == null) return;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
}
