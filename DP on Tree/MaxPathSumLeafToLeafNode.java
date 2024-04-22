public class MaxPathSumLeafToLeafNode{
  public static int Solve(Node root, int res){
    if(root == null){
      return 0;
    }

    int l = Solve(root.left, res);
    int r = Solve(root.right, res);

    int temp = Math.max(l, r) + root.value;

    if(root.left == null && root.right == null){
      temp = Math.max(temp, root.value);
    }

    int ans = Math.max(temp, l + r + root.value);
    res = Math.max(res, ans);

    return ans;
  }
}
