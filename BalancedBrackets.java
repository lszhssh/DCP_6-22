import java.util.HashMap;
import java.util.Stack;

// 6/9/22

public class BalancedBrackets {
    Stack<String> bracketStack;
    HashMap<String, String> bracketPairs = new HashMap<>();

    public BalancedBrackets() {
        this.bracketStack = new Stack<String>();
        this.bracketPairs.put("(", ")");
        this.bracketPairs.put("[", "]");
        this.bracketPairs.put("{", "}");
    }

    public boolean isBalanced(String bracketSequence) {
        for (int i = 0; i < bracketSequence.length(); i++) {
            if (this.bracketPairs.containsKey(bracketSequence.substring(i, i+1))) {
                this.bracketStack.push(bracketSequence.substring(i, i+1));
            } else if (this.bracketPairs.containsValue(bracketSequence.substring(i, i+1))) {
                if (this.bracketStack.empty()) {
                    return false;
                }
                String topOfStack = this.bracketStack.pop();
                if (!this.bracketPairs.get(topOfStack).equals(bracketSequence.substring(i, i+1))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BalancedBrackets bb = new BalancedBrackets();
        
        String bs1 = "(())[{}]";
        System.out.println(bb.isBalanced(bs1)); //exp: true

        String bs2 = "())[{}]";
        System.out.println(bb.isBalanced(bs2)); //exp: false
    }
}