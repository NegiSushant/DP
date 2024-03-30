import java.util.Arrays;

public class MemoizedKnapSack {
    static int[][] t = new int[1001][1001];
    public static void main(String[] args) {
        int[] wt = {2, 5, 6, 8, 9};
        int[] val = {3, 5, 1, 8, 10};
        int cap = 12;
        int n = wt.length;

        for(int[] row : t){
            Arrays.fill(row, -1);
        }

        System.out.println(Memo(wt, val, cap, n));
    }

    private static int Memo(int[] wt, int[] val, int cap, int n) {
        if(n == 0 || cap == 0){
            return 0;
        }

        if(t[n][cap]!= -1){
            return t[n][cap];
        }

        if(wt[n-1] <= cap){
            return t[n][cap] = Math.max(val[n-1] + Memo(wt, val, cap - wt[n-1], n -1), Memo(wt, val, cap, n -1));
        }

        return t[n][cap] = Memo(wt, val, cap, n-1);
    }
}
