public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "aabebcdd";
        System.out.println(RepeateSequence(s));
    }

    private static int RepeateSequence(String s) {
        int n = s.length();
        int[][] t = new int[n+1][n+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }else if(s.charAt(i-1) == s.charAt(j-1) && i!= j){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return t[n][n];
    }
}
