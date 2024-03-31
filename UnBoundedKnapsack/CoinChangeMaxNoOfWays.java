public class CoinChangeMaxNoOfWays {
    public static void main(String[] args) {
        int[] coin = {1,2,3,4};
        int sum = 5;
        int n = coin.length;
        System.out.println(MaxNumOfWays(coin, sum, n));
    }

    private static int MaxNumOfWays(int[] coin, int sum, int n) {
        int[][] t = new int[n+1][sum+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i == 0) t[i][j] = 0;
                else if (j == 0) {
                    t[i][j] = 1;
                }else if(coin[i-1] <= j){
                    t[i][j] = t[i][j - coin[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }


}
