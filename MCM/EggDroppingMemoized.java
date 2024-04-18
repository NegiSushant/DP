import java.util.Arrays;

public class EggDroppingMemoized {
    static int[][] t= new int[100][100];
    public static void main(String[] args){
        int egg = 3;
        int flor = 5;

        for(int[] row : t){
            Arrays.fill(row, -1);
        }
        System.out.println(Solve(egg, flor));
    }

    public static int Solve(int e, int f){
        if(f == 1 || f == 0){
            return f;
        }
        if(e == 1){
            return f;
        }

        if(t[e][f] != -1){
            return t[e][f];
        }

        int min = Integer.MAX_VALUE;

        for(int k = 1; k <= f; k++){
            int temp = 1+ Math.max(Solve(e-1, k - 1), Solve(e, f-k));
            min = Math.min(min, temp);
        }
        return t[e][f] = min;
    }
}
