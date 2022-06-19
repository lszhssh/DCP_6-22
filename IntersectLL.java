// 6/2/22

public class IntersectLL {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node root;
    int size;

    public IntersectLL(Node root) {
        this.root = root;
        size = 1;
    }

    public void add(Node node) {
        Node currNode = this.root;
        for (int i = 1; i < this.size; i++) {
            currNode = currNode.next;
        }
        currNode.next = node;
        this.size++;
    }

    public static int intersect(IntersectLL l1, IntersectLL l2) {
        Node l1Pointer = l1.root;
        Node l2Pointer = l2.root;
        if (l1.size > l2.size) {
            int diff = l1.size - l2.size;
            for (int i = 0; i < diff; i++) {
                l1Pointer = l1Pointer.next;
            }
        } else if (l1.size < l2.size) {
            int diff = l2.size - l1.size;
            for (int i = 0; i < diff; i++) {
                l2Pointer = l2Pointer.next;
            }
        }
        while (l1Pointer.val != l2Pointer.val) {
            l1Pointer = l1Pointer.next;
            l2Pointer = l2Pointer.next;
        }
        return l1Pointer.val;
    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(3);
        Node n3 = new Node(7);
        Node n4 = new Node(99);
        Node n5 = new Node(1);
        Node nX = new Node(8);
        Node nY = new Node(10);

        IntersectLL l1 = new IntersectLL(n1);
        l1.add(n2);
        l1.add(n3);
        l1.add(nX);
        l1.add(nY);

        IntersectLL l2 = new IntersectLL(n4);
        l2.add(n5);
        l2.add(nX);
        l2.add(nY);

        System.out.println(intersect(l1, l2));
    }
}