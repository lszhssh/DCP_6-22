import java.util.ArrayList;
import java.util.Arrays;

// 6/4/22:

// Given a dictionary of words and a string made up of those words (no spaces),
// return the original sentence in a list. If there is more than one possible 
// reconstruction, return any of them. If there is no possible reconstruction,
// then return null.
// For example, given the set of words 'quick', 'brown', 'the', 'fox', and the
// string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].
// Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the 
// string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] 
// or ['bedbath', 'and', 'beyond'].

// Solution time: 40 minutes

public class StringConstr {
    public static ArrayList<String> strConstr(String target, ArrayList<String> dict) {
        ArrayList<ArrayList<String>> canConstr = new ArrayList<>();
        for (int i = 0; i < target.length() + 1; i++) {
            canConstr.add(new ArrayList<String>());
        }
        for (int i = 0; i < target.length(); i++) {
            for (String str : dict) {
                int newIdx = i + str.length();
                if (newIdx <= canConstr.size()) {
                    if (target.substring(i).indexOf(str) == 0) {
                        if (canConstr.get(newIdx).isEmpty()) {
                            for (String s : canConstr.get(i)) {
                                canConstr.get(newIdx).add(s);
                            }
                            canConstr.get(newIdx).add(str);
                        }
                    }
                }
            }
        }
        return canConstr.get(target.length());
    }

    public static void main(String[] args) {
        // ArrayList<String> dict = new ArrayList<>(Arrays.asList("the", "quick", "brown", "fox"));
        // String target = "thequickbrownfox";
        // ArrayList<String> result = StringConstr.strConstr(target, dict);
        // for (String s : result) {
        //     System.out.print(s + " ");
        // }

        // ArrayList<String> dict = new ArrayList<>(Arrays.asList("bed", "bath", "bedbath", "and", "beyond"));
        // String target = "bedbathandbeyond";
        // ArrayList<String> result = StringConstr.strConstr(target, dict);
        // for (String s : result) {
        //     System.out.print(s + " ");
        // }

        ArrayList<String> dict = new ArrayList<>(Arrays.asList("bed", "bath", "bedbath", "and", "beyond"));
        String target = "bedbathandbeyon";
        ArrayList<String> result = StringConstr.strConstr(target, dict);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}