public class LCSubStringPrint {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";

        int n = x.length();
        int m = y.length();

        System.out.println(PrintLCSubstring(x, y, n, m));
    }

    private static String PrintLCSubstring(String x, String y, int n, int m) {
        int[][] t = new int[n+1][m+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if(i == 0 || j == 0){
                    t[i][j]=0;
                }else if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        int i = n, j = m;
        StringBuilder ans = new StringBuilder();
        while (i > 0 && j > 0){
            if(x.charAt(i-1) == y.charAt(j-1)){
                ans.append(x.charAt(i - 1));
                i--;
                j--;
            }else{
                if(t[i][j-1] > t[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        //String sol = ans.reverse().toString();
        return ans.reverse().toString();

    }
}
