public class SequencePatternMatching {
    public static void main(String[] args) {
        String x = "axy";
        String y = "adxcpy";

        int n = x.length(), m = y.length();

        System.out.println(PatternMatch(x, y, n,m));
    }
    private static boolean PatternMatch(String x, String y, int n, int m) {
        int[][] t = new int[n+1][m+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }else if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        int tm = t[n][m];

       return tm == n;
    }
}
