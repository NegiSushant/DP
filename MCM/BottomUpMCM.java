public class BottomUpMCM {
    public int BottomUp(int[] values) {

        int n = values.length;
        int[][] t = new int[n][n];

        // no need to initialize the t for base case. because all the values are already 0 in t initially

        for (int i = n-1; i >= 1; i--){
            for (int j = i+1; j<n; j++){
                int mini = Integer.MAX_VALUE;
                // for partition
                for (int k = i; k <= j-1; k++){
                    int steps = values[i-1] * values[k] * values[j] + t[i][k] + t[k+1][j];
                    mini = Math.min(mini,steps);
                }
                t[i][j] = mini;
            }
        }
        return t[1][n-1];

    }
}
