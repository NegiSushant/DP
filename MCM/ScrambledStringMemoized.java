import java.util.HashMap;
import java.util.Map;

public class ScrambledStringMemoized {
    static Map<String, Boolean> mp = new HashMap<>();

    public static void main(String[] args) {
        String a = "great";
        String b = "rgeat";

        System.out.println(Solve(a, b));
    }

    public static boolean Solve(String a, String b){
        int n = a.length();

        if(a.equals(b)) return true;

        String key = a +" "+b;

        if(mp.containsKey(key)){
            return mp.get(key);
        }

        for (int i = 1; i < n; i++) {
//            boolean swap = Solve(a.substring(0, i), b.substring(n-i, n)) && Solve(a.substring(0, n-i), b.substring(i, n));
//            boolean unSwap = Solve(a.substring(0, i), b.substring(0, i)) && Solve(a.substring(i, n), b.substring(i, n));

            boolean swap = Solve(a.substring(0, i), b.substring(n-i)) && Solve(a.substring(i), b.substring(0, n-i));
            boolean unSwap = Solve(a.substring(0, i), b.substring(0, i)) && Solve(a.substring(i), b.substring(i));

            if(swap || unSwap) {
                mp.put(key, true);
                return true;
            }
        }

        mp.put(key, false);
        return false;
    }

//    Map<String, Boolean> mp = new HashMap<>();
//
//    public boolean isScramble(String s1, String s2) {
//        int n = s1.length();
//        if (s1.equals(s2)) return true;
//        if (n == 1) return false;
//
//        String key = s1 + " " + s2;
//
//        if (mp.containsKey(key)) return mp.get(key);
//
//        for (int i = 1; i < n; i++) {
//            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))){
//                mp.put(key, true);
//                return true;
//            }
//
//            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))){
//                mp.put(key, true);
//                return true;
//            }
//        }
//
//        mp.put(key, false);
//        return false;
//    }
}
