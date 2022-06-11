// 6/7/22:

// Implement regular expression matching with the following special characters:
// . (period) which matches any single character
// * (asterisk) which matches zero or more of the preceding element
// That is, implement a function that takes in a string and a valid regular expression
// and returns whether or not the string matches the regular expression.
// For example, given the regular expression "ra." and the string "ray", 
// your function should return true. The same regular expression on the string "raymond" should return false.
// Given the regular expression ".*at" and the string "chat", your function should return true. 
// The same regular expression on the string "chats" should return false.

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