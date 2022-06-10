// 6/6/22: 

// Implement locking in a binary tree. A binary tree node can be locked or unlocked 
// only if all of its descendants or ancestors are not locked.
// Design a binary tree node class with the following methods:
// is_locked, which returns whether the node is locked
// lock, which attempts to lock the node. If it cannot be locked, then it should return false.
// Otherwise, it should lock it and return true.
// unlock, which unlocks the node. If it cannot be unlocked, then it should return false. 
// Otherwise, it should unlock it and return true.
// You may augment the node to add parent pointers or any other property you would like.
// You may assume the class is used in a single-threaded program, so there is no need 
// for actual locks or mutexes. Each method should run in O(h), where h is the height of the tree.

public class LockingBT {
    static class Node {
        int value;
        boolean isLocked;
        Node parent;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
            this.isLocked = false;
        }
    }

    Node root;
    public LockingBT(int value) {
        this.root = new Node(value);
    }

    public boolean isLocked(Node node) {
        return node.isLocked;
    }

    public boolean lock(Node node) {
        if (checkAncestors(node) && checkDescendants(node)) {
            node.isLocked = true;
            return true;
        }
        return false;
    }

    public boolean unlock(Node node) {
        if (checkAncestors(node) && checkDescendants(node)) {
            node.isLocked = false;
            return true;
        }
        return false;
    }

    public boolean checkAncestors(Node node) {
        while (node.parent != null) {
            if (node.parent.isLocked) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDescendants(Node node) {
        if (node == null) {
            return true;
        }
        if (node.leftChild == null && node.rightChild == null) {
            if (node.isLocked) {
                return false;
            }
            return true;
        }
        return checkDescendants(node.leftChild) && checkDescendants(node.rightChild);
    }
    
    public static void main(String[] args) {
        LockingBT bt = new LockingBT(1);
        bt.root.leftChild = new Node(2);
        bt.root.rightChild = new Node(3);
        System.out.println(bt.lock(bt.root));
        System.out.println(bt.isLocked(bt.root));
    }
}