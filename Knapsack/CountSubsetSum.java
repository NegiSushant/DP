public class CountSubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 10, 5};
        int sum = 10;
        int n = arr.length;

        System.out.println(NumSubset(arr, sum, n));
    }
    public static int NumSubset(int[] arr, int sum, int n){
        int[][] t = new int[n+1][sum+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i == 0) t[i][j] = 0;
                else if (j == 0) t[i][j] = 1;
                else if (arr[i - 1] <= j) {
                    t[i][j] = t[i-1][j- arr[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
