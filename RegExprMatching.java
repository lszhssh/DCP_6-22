// 6/7/22

public class RegExprMatching {
    public static boolean matchFirstChar(String str, String regex) {
        return str.charAt(0) == regex.charAt(0) || (regex.charAt(0) == '.' && str.length() > 0);
    }

    public static boolean match(String str, String regex) {
        if (regex.isEmpty()) {
            return str.isEmpty();
        }
        if (regex.length() == 1 || regex.charAt(1) != '*') {
            if (matchFirstChar(str, regex)) {
                return match(str.substring(1), regex.substring(1));
            } else {
                return false;
            }
        } else {
            if (matchFirstChar(str, regex)) {
                // for (int i = 0; i < str) how to check?
                if (regex.length() == 2) {
                    return true;
                }
                for (int i = 0; i < str.length() - 1; i++) {
                    if (str.substring(i).equals(regex.substring(2))) {
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String regex = ".*at";
        String str = "chats";
        System.out.println(RegExprMatching.match(str, regex));
    }
}