public class EggDroppingRecursion {

    public static void main(String[] args) {
        int e = 3;
        int f = 5;

        System.out.println(Solve(e, f));
    }

    public static int Solve(int e, int f){
        if(f == 0 || f == 1){
            return f;
        }

        if(e == 1){
            return f;
        }

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= f; k++) {
            int temp = 1 + Math.max(Solve(e-1, k-1), Solve(e, f-k));

            min = Math.min(min, temp);
        }

        return min;
    }
}
