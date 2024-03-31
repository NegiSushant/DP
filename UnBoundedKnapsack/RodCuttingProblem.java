public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] length = {2, 5, 6, 8, 9};
        int[] price = {3, 5, 1, 8, 10};
        int N = 12;
        int n = length.length;

        System.out.println(RodCut(length, price, N, n));
    }
    public static int RodCut(int[] length, int[] price, int N, int n){
        int[][] t = new int[n+1][N+1];

        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < N+1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                } else if (length[i - 1] <= j) {
                    t[i][j] = Math.max(price[i-1]+t[i][j-length[i-1]], t[i-1][j]);
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][N];
    }
}
