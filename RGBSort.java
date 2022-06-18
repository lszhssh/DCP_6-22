// 6/17/22

public class RGBSort {
    public static void swap(char[] letters, int currIdx, int currSortedIdx) {
        char temp = letters[currSortedIdx];
        letters[currSortedIdx] = letters[currIdx];
        letters[currIdx] = temp;
    }

    public static char[] rgbSort(char[] letters) {
        int currSortedIdx = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == 'R') {
                swap(letters, i, currSortedIdx);
                currSortedIdx++;
            }
        }
        for (int i = currSortedIdx; i < letters.length; i++) {
            if (letters[i] == 'G') {
                swap(letters, i, currSortedIdx);
                currSortedIdx++;
            }
        }
        return letters;
    }

    public static void main(String[] args) {
        char[] letters = new char[] {'G', 'B', 'R', 'R', 'B', 'R', 'G', 'B'};
        // char[] letters = new char[] {'R', 'R', 'R'};
        RGBSort.rgbSort(letters);
        for (char c : letters) {
            System.out.print(c + " ");
        }
    }
}