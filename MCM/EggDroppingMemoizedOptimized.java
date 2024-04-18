/*

https://leetcode.com/problems/super-egg-drop/description/

You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.

You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than
f will break, and any egg dropped at or below floor f will not break.

Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks,
you can no longer use it. However, if the egg does not break, you may reuse it in future moves.

Return the minimum number of moves that you need to determine with certainty what the value of f is.



Example 1:

Input: k = 1, n = 2
Output: 2
Explanation:
Drop the egg from floor 1. If it breaks, we know that f = 0.
Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
If it does not break, then we know f = 2.
Hence, we need at minimum 2 moves to determine with certainty what the value of f is.
Example 2:

Input: k = 2, n = 6
Output: 3
Example 3:

Input: k = 3, n = 14
Output: 4


Constraints:

1 <= k <= 100
1 <= n <= 104

 */
import java.util.Arrays;

public class EggDroppingMemoizedOptimized {
    static int[][] t = new int[100][100];
    public static void main(String[] args){
        int egg = 3; int flor = 25;
        for(int[] row : t){
            Arrays.fill(row, -1);
        }

        System.out.println(Solve(egg, flor));
    }

    public static int Solve(int e, int f){
        if(f == 1 || f == 0){
            return f;
        }
        if(e == 1){
            return f;
        }

        if(t[e][f] != -1){
            return t[e][f];
        }

        int min = Integer.MAX_VALUE;

        for(int k = 1; k <= f; k++){
            int low = 0, high = 0;
            if(t[e-1][k-1] != -1){
                low = t[e-1][k-1];
            }else{
                low = Solve(e-1, k - 1);
                t[e-1][k-1] = low;
            }
            if(t[e][f-k] != -1){
                high = t[e][f-k];
            }else{
                high = Solve(e, f-k);
                t[e][f-k] = high;
            }

            int temp = 1 + Math.max(low, high);
            min = Math.min(min, temp);
        }
        return t[e][f] =min;
    }
}

//class Solution {
//
//    public static int [][] t;
//    public int superEggDrop(int k, int n) {
//        t=new int[k+1][n+1];
//        for(int [] i:t) Arrays.fill(i,-1);
//        return solve(k,n);
//    }
//    public static int solve(int e,int f){
//        if(f==0 || f==1 || e==1) return f;
//        if(t[e][f]!=-1) return t[e][f];
//        int ans=Integer.MAX_VALUE,l=1,h=f;
//        // use binary search insted of linear search
//        while(l<=h){
//            int mid=(h+l)/2;
//            int left=solve(e-1,mid-1);
//            int right=solve(e,f-mid);
//            int temp=1+Math.max(left,right);
//            if(left<right) l=mid+1;
//            else h=mid-1;
//            ans=Math.min(ans,temp);
//        }
//        return t[e][f]=ans;
//    }
//}
