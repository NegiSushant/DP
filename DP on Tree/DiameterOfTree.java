/*
take any 2 leaf node
find the number of node along longest path between two leafs.
*/
public class DiameterOfTree{
  public static int Solve(Node root, int res){
    if(root == null){
      return 0;
    }
    int l = Solve(root.left, res);
    int r = SOlve(root.right, res);

    int temp = Math.max(l, r) + 1;
    int ans = Math.max(temp, (1+r+l));

    res = Math.max(res, ans);

    return temp;
  }
    
}

