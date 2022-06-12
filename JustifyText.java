import java.util.ArrayList;
import java.util.Arrays;

// 6/10/22

public class JustifyText {
    public static ArrayList<String> justifyText(ArrayList<String> words, int lineLen) {
        ArrayList<String> justified = new ArrayList<>();
        boolean complete = false;
        int currIdx = 0;
        while (currIdx < words.size()) {
            int currLineLen = 0;
            ArrayList<String> currLine = new ArrayList<>();
            while (currIdx < words.size() && 
                    (currLineLen + words.get(currIdx).length() + 1 <= lineLen || 
                        currLineLen + words.get(currIdx).length() == lineLen)) {
                currLine.add(words.get(currIdx));
                if (currLineLen + words.get(currIdx).length() + 1 <= lineLen) {
                    currLineLen += words.get(currIdx).length() + 1;
                } else {
                    currLineLen += words.get(currIdx).length();
                }
                currIdx++;
            }
            int numPaddingSpaces = lineLen - currLineLen + 1;
            // if (currLineLen != lineLen) {
            //     numPaddingSpaces = lineLen - currLineLen + 1;
            // }
            int numExtraSpacesPerWord = 0;
            int numUnequalPadding = 0;
            if (currLine.size() != 1) {
                numExtraSpacesPerWord = numPaddingSpaces / (currLine.size() - 1);
                numUnequalPadding = numPaddingSpaces % (currLine.size() - 1); //check this
            } else {
                numExtraSpacesPerWord = numPaddingSpaces;
            }
            String justifiedLine = "";
            for (int i = 0; i < currLine.size() - 1; i++) {
                justifiedLine += currLine.get(i) + "*";
                for (int j = 0; j < numExtraSpacesPerWord; j++) {
                    justifiedLine += "*";
                }
                if (numUnequalPadding != 0) {
                    justifiedLine += "*";
                    numUnequalPadding--;
                }
            }
            justifiedLine += currLine.get(currLine.size() - 1);
            justified.add(justifiedLine);
        }
        return justified;  
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("the", "quick", "brown", "fox",
            "jumps", "over", "the", "lazy", "dog"));
        int lineLen = 16;
        ArrayList<String> justified = JustifyText.justifyText(words, lineLen);
        for (String str : justified) {
            System.out.println(str);
        }
    }
}