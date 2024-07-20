public class LCSubstring {
    public static void main(String[] args){
        String x = "zrabcdef";
        String y = "abcdgh";

        int n = x.length();
        int m = y.length();

        System.out.println(LongSubstring(x, y, n, m));

    }
    private static int LongSubstring(String x, String y, int n, int m){
        int[][] t = new int[n+1][m+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }else if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                max = Math.max(max, t[i][j]);
            }
        }
        return max;
    }
}
