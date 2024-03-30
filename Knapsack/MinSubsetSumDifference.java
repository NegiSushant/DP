// Giving wrong answer for test case {1, 2}
public class MinSubsetSumDifference {
    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        System.out.println(SubsetSum(arr, sum));
    }

    public static int SubsetSum(int[] arr, int sum){
        int n = arr.length;
        boolean[][] t = new boolean[n+1][sum+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i == 0) t[i][j] = false;
                else if (j == 0) t[i][j] = true;
                else if (arr[i - 1] <= j) {
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = sum/2; i>=0; i--){
            if(t[n][i]){
                min = sum - 2 * i;
                break;
            }
        }
        return min;
    }

//    public static int Difference(int[] arr, int n){
//
//    }
}
