import java.util.Arrays;

public class MemoizedNumPalindromPartitioning {
    static int[][] t;
    public static void main(String[] args) {

        String s = "nitik";

        int i = 0, j = s.length()-1;
        t = new int[j+1][j+1];

        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        System.out.println(solve(s, i, j));
    }

    private static int solve(String s, int i, int j) {
        if(i >= j || isPalindrom(s, i, j)) return 0;
        if(t[i][j] != -1) return t[i][j];

        int min = Integer.MAX_VALUE;
        int right, left;
        for (int k = i; k <= j - 1; k++) {


            if(t[i][k] != -1){
                left = t[i][k];
            }else{
                left = solve(s, i, k);
                t[i][k] = left;
            }

            if(t[k+1][j] != -1){
                right = t[k+1][j];
            }else{
                right = solve(s, k+1, j);
                t[k+1][j] = right;
            }
//            int temp = 1 + solve(s, i,k) + solve(s, k+1, j);
            int temp = 1+ right + left;
            min = Math.min(min, temp);
        }
        return t[i][j] = min;
    }

    private static boolean isPalindrom(String s, int i, int j) {
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
