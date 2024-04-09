import java.util.Arrays;

public class MemoizedMCM {
    static int[][] t = new int[1001][1001];
    public static void main(String[] args) {
        int[] arr = {17,97,74,55,68,64,46,48,9,2,70,39,52,31,86,2,31,8,28,78};
        for (int [] row : t) {
            Arrays.fill(row, -1);
        }
        System.out.println(Memoized(arr, 1, arr.length-1));
    }
    private static int Memoized(int[] arr, int i, int j){
        if(i>= j) return 0;

        if(t[i][j] != -1) return t[i][j];

        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int temp = Memoized(arr, i, k) + Memoized(arr, k+1, j) +(arr[i-1] * arr[k] * arr[j]);
            min = Math.min(min, temp);
        }
        return t[i][j]=min;
    }
}
