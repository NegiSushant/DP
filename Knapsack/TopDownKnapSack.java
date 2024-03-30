public class TopDownKnapSack {
    public static void main(String[] args) {
        int[] wt = {2, 5, 6, 8, 9};
        int[] val = {3, 5, 1, 8, 10};
        int cap = 12;
        int n = wt.length;

        System.out.println(TopDown(wt, val, cap, n));
    }
    public static int TopDown(int[] wt, int[] val, int cap, int n){
        int[][] t = new int[n+1][cap+1];

        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < cap+1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j]);
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
         return t[n][cap];
    }
}
