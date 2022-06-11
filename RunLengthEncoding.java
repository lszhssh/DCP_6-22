// 6/11/22

public class RunLengthEncoding {
    public static String runLengthEncode(String original) {
        String encoded = "";
        String prevChar = original.substring(0, 1);
        int prevCharOccurrences = 1;
        for (int i = 1; i < original.length(); i++) {
            String currChar = original.substring(i, i+1);
            if (currChar.equals(prevChar)) {
                prevCharOccurrences++;
            } else {
                encoded += prevCharOccurrences + prevChar;
                prevChar = currChar;
                prevCharOccurrences = 1;
            }
        }
        encoded += prevCharOccurrences + prevChar;
        return encoded;
    }

    public static String runLengthDecode(String encoded) {
        String decoded = "";
        for (int i = 0; i < encoded.length(); i += 2) {
            int numOccurrences = Integer.valueOf(encoded.substring(i, i+1));
            String ltr = encoded.substring(i+1, i+2);
            for (int j = 0; j < numOccurrences; j++) {
                decoded += ltr;
            }
        }
        return decoded;
    }

    public static void main(String[] args) {
        String original = "AAAABBCDD";
        String encoded = RunLengthEncoding.runLengthEncode(original);
        String decoded = RunLengthEncoding.runLengthDecode(encoded);

        System.out.println(original);
        System.out.println(encoded);
        System.out.println(decoded);
    }
}