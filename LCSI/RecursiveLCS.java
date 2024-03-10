public class RecursiveLCS {
    public static void main(String[] args){
        String x = "abcdgh";
        String y = "abedfhr";

        int n = x.length(), m = y.length();
        System.out.println(LCS(x, y, n, m));
    }

    private static int LCS(String x, String y, int n, int m) {
        //Base Condition
        if(n == 0 || m == 0){
            return 0;
        }
        //Choice Diagram
        if(x.charAt(n-1) == y.charAt(m-1)){
            return 1+ LCS(x, y, n-1, m-1);
        }else{
            return Math.max(LCS(x, y, n, m-1), LCS(x, y, n-1, m));
        }
    }
}
