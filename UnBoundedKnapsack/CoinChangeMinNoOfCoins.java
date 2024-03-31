public class CoinChangeMinNoOfCoins {
    public static void main(String[] args) {
        int[] coin = {1, 2, 3};
        int sum = 0;
        int n = coin.length;

        System.out.println(MinNumOfCoins(coin, sum, n));
    }
    public static int MinNumOfCoins(int[] coin, int sum, int n){
        int[][] t= new int[n+1][sum+1];
        //for 1st row and 1st column
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i== 0) t[i][j] = Integer.MAX_VALUE;
                else if (j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        //for filling 2nd row
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(j % coin[0] == 0){
                    t[i][j] = j / coin[0];
                }else{
                    t[i][j] = Integer.MAX_VALUE-1;
                }
            }
        }

        //for filling after 2nd row
        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < sum + 1; j++) {
                if(coin[i-1] <= j){
                    t[i][j] = Integer.min(t[i][j-coin[i-1]] + 1, t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
