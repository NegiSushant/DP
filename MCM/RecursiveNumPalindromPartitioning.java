public class RecursiveNumPalindromPartitioning {
    public static void main(String[] args) {
        String s = "nitik";
        int i = 0, j = s.length()-1;

        System.out.println(solve(s, i, j));
    }

    private static int solve(String s, int i, int j) {
        if(i >= j) return 0;
        if(isPalindrom(s, i, j)) return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = 1 + solve(s, i,k) + solve(s, k+1, j);

            min = Math.min(min, temp);
        }
        return min;
    }

    private static boolean isPalindrom(String s, int i, int j) {
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
