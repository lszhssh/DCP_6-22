// 6/17/22

public class RGBSort {
    public static void swap(char[] letters, int idx1, int idx2) {
        char temp = letters[idx2];
        letters[idx2] = letters[idx1];
        letters[idx1] = temp;
    }

    public static void rgbSort(char[] letters) {
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
    }

    public static void optimRgbSort(char[] letters) {
        int low = 0;
        int mid = 0;
        int high = letters.length - 1;
        while (mid <= high) {
            if (letters[mid] == 'R') {
                swap(letters, low, mid);
                low++;
                mid++;
            } else if (letters[mid] == 'G') {
                mid++;
            } else {
                swap(letters, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        char[] letters = new char[] {'G', 'B', 'R', 'R', 'B', 'R', 'G', 'B'};
        // char[] letters = new char[] {'R', 'R', 'R'};
        // RGBSort.rgbSort(letters);
        RGBSort.optimRgbSort(letters);
        for (char c : letters) {
            System.out.print(c + " ");
        }
    }
}