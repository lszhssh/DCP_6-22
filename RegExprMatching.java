// 6/7/22

public class RegExprMatching {
    public static boolean onlyPeriods(String regExpr, String str) {
        int start = 0;
        int end = 0;
        while (regExpr.indexOf(".") != -1) {
            end = regExpr.indexOf(".");
            if (regExpr.substring(start, end).equals(str.substring(start, end))) {
                if (regExpr.charAt(end) == str.charAt(end)) {
                    start = end + 1;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (start >= regExpr.length() || start >= str.length()) {
            
        }
        if (regExpr.substring(start).equals(str.substring(start))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String regExpr = "ra.";
        String str = "ray";
        System.out.println(RegExprMatching.onlyPeriods(regExpr, str));
    }
}