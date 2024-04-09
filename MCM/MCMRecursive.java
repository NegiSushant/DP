public class MCMRecursive {
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        System.out.println(Solve(arr, 1, arr.length-1));
    }

    private static int Solve(int[] arr, int i, int j){
        if(i >= j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int temp = Solve(arr, i, k) + Solve(arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);

            min = Math.min(min, temp);
        }

        return min;
    }
}
