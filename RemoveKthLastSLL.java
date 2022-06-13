import java.util.Iterator;
import java.util.LinkedList;

// 6/8/22

public class RemoveKthLastSLL {
    public static void removeKthLastElem(LinkedList list, int k) {
        int idx = list.size() - k + 1;
        Iterator iter = list.iterator();
        for (int i = 0; i < idx; i++) {
            iter.next();
        }
        iter.remove();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
        int k = 1;
        removeKthLastElem(list, k);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}