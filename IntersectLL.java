// Problem from 6/2/22:

// Given two singly linked lists that intersect at some point, 
// find the intersecting node. The lists are non-cyclical.
// For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, 
// return the node with value 8.
// In this example, assume nodes with the same value are 
// the exact same node objects.
// Do this in O(M + N) time (where M and N are 
// the lengths of the lists) and constant space.

public class IntersectLL {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node root;

    public IntersectLL(int val) {
        this.root = new Node(val);
    }

    // Naive solution: for each node in the first list, see if that node appears
    // in the second list (time: O(M*N), space: O(1))

    // Optimized solution:
    // - Singly LL => we can only move forward in the list => only move if we can 
    // guarantee that that node isn't the intersect
        // [] How do we know that unless we traverse the entire list?
            // - Two high-level possibilities:
                // 1. Manipulate the DS to find the answer in the desired time and space
                    // - We can't make BSTs out of the SLLs because that wouldn't be O(1) space;
                    // in any case, that would only reduce the time to O(M*logN)
                    // - Serialize SLL into String would initially satisfy the time and space
                    // constraints, but any further operations necessary to find the answer
                    // would not satisfy those constraints
                        // - Similarly, keeping a Hashtable of values and occurrences would
                        // violate the desired space complexity
                        // - If we add all Nodes into an ArrayList, we can solve the problem in 
                        // O(M+N) time and O(M+N) space. This seems to be the best solution I've
                        // thought of.
                // 2. Some undiscovered algorithm that can answer the question without
                // manipulating the DS
                    // - Rare
    // - O(1) space => only storing a variable, not another DS

    public static void main(String[] args) {
        String sll1 = "3,7,8,10";
        String[] s1 = new String[5];
    }
}