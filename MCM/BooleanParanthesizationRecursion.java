// Evaluate expression to true or boolean parenthesizasion Recursive,
public class BooleanParanthesizationRecursion {

    public static void main(String[] args) {
        String s = "F^T^T";
        int i = 0;
        int j = s.length()-1;
        boolean isTF = true;

        System.out.println(Solve(s, i, j, isTF));
    }

    public static int Solve(String s, int i, int j, boolean isTF){
        if(i > j){
            return 0;
        }
        if(i == j){
            if(isTF){
                return s.charAt(i) == 'T' ? 1 : 0;
            }else{
                return s.charAt(i) == 'F' ? 1: 0;
            }
        }

        int ans = 0;
        for (int k = i+1; k <= j - 1; k=k+2) {
            int lt = Solve(s, i, k-1, true);
            int lf = Solve(s, i, k-1, false);
            int rt = Solve(s, k+1, j, true);
            int rf = Solve(s, k+1, j, false);

            if (s.charAt(k) == '&') {
                if(isTF){
                    ans = ans + (lt * rt);
                }else {
                    ans = ans + (lt * rf) + (lf * rt) + (lf * rf);
                }
            }else if(s.charAt(k) == '|') {
                if (isTF) {
                    ans = ans +( lt * rt) + (lt * rf) + (lf * rt);
                } else {
                    ans = ans + (lf * rf);
                }
            } else if (s.charAt(k) == '^') {
                if(isTF){
                    ans = ans + (lf * rt) + (lt * rf);
                }else {
                    ans = ans + (lt * rt) + (lf * rf);
                }
            }
        }
        return ans;
    }
}
