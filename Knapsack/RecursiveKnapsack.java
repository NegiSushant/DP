public class RecursiveKnapsack {
    public static void main(String[] args) {
        int[] wt = {2, 5, 6, 8, 9};
        int[] val = {3, 5, 1, 8, 10};
        int cap = 12;
        int n = wt.length;

        System.out.println(knapSack(wt, val, cap, n));
    }

    public static int knapSack(int[] wt, int[] val, int capacity, int n){
        if(n == 0 || capacity == 0){
            return 0;
        }

        if(wt[n-1] <=  capacity){
            return Math.max(val[n-1] + knapSack(wt, val, capacity-wt[n-1], n-1), knapSack(wt, val, capacity, n-1));
        }

        return knapSack(wt, val, capacity, n-1);
    }
}
