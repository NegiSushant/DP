public class PrintShortestCommonSuperSequence {
    public static void main(String[] args) {
        String x = "abac";
        String y = "cab";
        int n = x.length(), m = y.length();

        System.out.println(SCS(x, y, n, m));
    }

    private static String SCS(String x, String y, int n, int m){
        int[][] t = new int[n+1][m+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if(i == 0 || j== 0){
                    t[i][j] = 0;
                }else if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        int i = n, j = m;
        StringBuilder s = new StringBuilder();

        while (i > 0 && j > 0){
            if(x.charAt(i-1) == y.charAt(j-1)){
                s.append(x.charAt(i-1));
                i--;
                j--;
            }else{
                if(t[i][j-1] > t[i-1][j-1]){
                    s.append(y.charAt(j-1));
                    j--;
                }else{
                    s.append(x.charAt(i - 1));
                    i--;
                }
            }
        }

        while (i > 0){
            s.append(x.charAt(i-1));
            i--;
        }
        while (j > 0){
            s.append(y.charAt(j-1));
            j--;
        }

        return s.reverse().toString();
    }
}
