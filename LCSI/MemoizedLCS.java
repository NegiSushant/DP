import java.util.Arrays;

public class MemoizedLCS {
    static int[][]t = new int[1001][1001];

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        int n = x.length(), m = y.length();

        //int[][] t = new int[n+1][m+1];
        for (int [] row: t) {
            Arrays.fill(row, -1);
        }

        System.out.println(MemoLCS(x, y, n, m));
        //System.out.println(MemoLCS(x, y, n, m, t));

//        System.out.println(Arrays.deepToString(t));
    }


    private static int MemoLCS(String x, String y, int n, int m) {

        if(n == 0 || m == 0){
            return 0;
        }
        if(t[n][m] != -1){
            return t[n][m];
        }

        if(x.charAt(n-1) == y.charAt(m-1)){
            return t[n][m] = 1+MemoLCS(x,y, n-1, m-1);
        }else{
            return t[n][m] = Math.max(MemoLCS(x, y, n, m-1), MemoLCS(x, y, n-1, m));
        }
    }
//    private static int MemoLCS(String x, String y, int n, int m, int[][] t) {
//
//        if(n == 0 || m == 0){
//            return 0;
//        }
//        if(t[n][m] != -1){
//            return t[n][m];
//        }
//
//        if(x.charAt(n-1) == y.charAt(m-1)){
//            return t[n][m] = 1+MemoLCS(x,y, n-1, m-1, t);
//        }else{
//            return t[n][m] = Math.max(MemoLCS(x, y, n, m-1, t), MemoLCS(x, y, n-1, m, t));
//        }
//    }
}
