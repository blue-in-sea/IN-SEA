/**
 * Given a binary search tree and a target number, find out whether there are a pair of TreeNodes that 
 * the sum of their values equals to the given target.
 */

public class 2SumBST {
    // BST Iterator 
    // Step 1
    // we have 1st iterator to iterate the BST from left to right
    // we have 2nd iterator to iterate the BST from right to left
    // Step 2
    // if (input[L] + input[R] > target) iterator.next2()
    // if (input[L] + input[R] < target) iterator.next1()
    public boolean findTarget(TreeNode root, int k) {
        
    }
    
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
    
    // 2 Sum: for-loop version
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);

        for(int i = 0, j = arr.size() - 1; i < j;){
            if(arr.get(i) + arr.get(j) == k) return true;
            if(arr.get(i) + arr.get(j) < k)i++;
            else j--;
        }
        return false;
    }
}
