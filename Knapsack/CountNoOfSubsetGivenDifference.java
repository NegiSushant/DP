public class CountNoOfSubsetGivenDifference {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2};
        int diff = 1;
        int n = arr.length;
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        int reqSum = (sum + diff) / 2;
        //System.out.println(countWithGivenSum(arr, n, diff));

        System.out.println(Counting(arr, reqSum, n));
    }

//    public static int subsetSum(int[] a, int n, int sum) {
//        // Initializing the matrix
//        int[][] dp = new int[n + 1][sum + 1];
//        // Initializing the first value of matrix
//        dp[0][0] = 1;
//        for (int i = 1; i <= sum; i++)
//            dp[0][i] = 0;
//        for (int i = 1; i <= n; i++)
//            dp[i][0] = 1;
//
//        for (int i = 1; i <= n; i++)
//        {
//            for (int j = 1; j <= sum; j++)
//            {
//                // if the value is greater than the sum
//                if (a[i - 1] <= j)
//                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i - 1]];
//                else
//                    dp[i][j] = dp[i - 1][j];
//            }
//        }
//
//        return dp[n][sum];
//    }
//
//    public static int countWithGivenSum(int[] arr, int n, int diff)
//    {
//        int sum=0;
//        for(int i=0;i<n;i++)
//            sum+=arr[i];
//
//        int reqSum=(diff+sum)/2;
//        return subsetSum(arr,n,reqSum);
//    }

    private static int Counting(int[] arr, int sum, int n) {
        int[][] t = new int[n+1][sum+1];
        t[0][0] = 1;
        for (int i = 1; i < sum + 1; i++) {
            t[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            t[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j] + t[i-1][j-(arr[i-1])];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
