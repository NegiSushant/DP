public class ScrambledStringRecursive {
    public static void main(String[] args) {
        String a = "great";
        String b = "rgeat";

        System.out.println(Solve(a, b));
    }

    public static boolean Solve(String a, String b){
        // if(a.length() != b.length()){
        //     return false;
        // }
        if(a.equals(b)){
            return true;
        }
        if(a.length() <= 1 ){
            return false;
        }

        int n = a.length();

        // if(n == 0) return true;
        boolean flag = false;

        for (int i = 1; i < n; i++) {
//            boolean swap = Solve(a.substring(0, i), b.substring(n-i, n)) && Solve(a.substring(0, n-i), b.substring(i, n));
//            boolean unSwap = Solve(a.substring(0, i), b.substring(0, i)) && Solve(a.substring(i, n), b.substring(i, n));

            boolean swap = Solve(a.substring(0, i), b.substring(n-i)) && Solve(a.substring(i), b.substring(0, n-i));
            boolean unSwap = Solve(a.substring(0, i), b.substring(0, i)) && Solve(a.substring(i), b.substring(i));

            if(swap || unSwap){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
