public class EqualSumPartition {
    public static void main(String[] args) {
        int[] num = {1,2,5};
        System.out.println(canPartition(num));
    }
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }
        return Subset(nums, sum/2, n);
    }

    public static boolean Subset(int[] arr, int sum, int n){
        boolean[][] t = new boolean[n+1][sum+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i == 0 ) t[i][j] = false;
                else if (j == 0) {
                    t[i][j] = true;
                } else if (arr[i-1] <= j) {
                    t[i][j] = t[i - 1][j- arr[i-1]] || t[i-1][j];
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][sum];
    }
}
