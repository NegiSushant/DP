public class InsertionAndDeletions {
    public static void main(String[] args) {
        String x = "heap";
        String y = "pea";

        int n = x.length();
        int m = y.length();
        System.out.print("Number of Deletion: ");
        System.out.println(n - LCS(x, y, n, m));
        System.out.print("Number of Insertion: ");
        System.out.println(m - LCS(x, y, n, m));

    }
    private static int LCS(String x, String y, int n, int m){
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
        return t[n][m];
    }

}
