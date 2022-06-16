import java.util.ArrayList;

// 6/3/22

public class MinRooms {
    static class TimeInterval {
        int start;
        int end;

        public TimeInterval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // public boolean overlap(Pair a, Pair b) {
        //     if ((a.start >= b.start && a.start <= b.end) || (b.start >= a.start))
        // }
    }

    // Source: https://www.baeldung.com/java-quicksort
    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
    
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    
    // Source: https://www.baeldung.com/java-quicksort
    public static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);
    
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
    
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
    
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
    
        return i+1;
    }    

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public static int minRooms(ArrayList<TimeInterval> timeIntervals) {
        // create and init arrays for start and end times
        int[] startTimes = new int[timeIntervals.size()];
        int[] endTimes = new int[timeIntervals.size()];
        for (int i = 0; i < timeIntervals.size(); i++) {
            startTimes[i] = timeIntervals.get(i).start;
            endTimes[i] = timeIntervals.get(i).end;
        }
        // sort those arrays
        quickSort(startTimes, 0, startTimes.length - 1);
        quickSort(endTimes, 0, endTimes.length - 1);
        // iterate thru arrays to find max num of overlaps
        int currStartIdx = 0;
        int currEndIdx = 0;
        int currNumOverlaps = 0;
        int maxNumOverlaps = 0;
        while (!(currStartIdx == startTimes.length - 1 && currEndIdx == endTimes.length - 1)) {
            if (startTimes[currStartIdx] <= endTimes[currEndIdx]) {
                currNumOverlaps++;
                maxNumOverlaps = max(currNumOverlaps, maxNumOverlaps);
                if (currStartIdx < startTimes.length - 1) {
                    currStartIdx++;
                } else {
                    currEndIdx++;
                }
            } else {
                currNumOverlaps = 0;
                if (currEndIdx < endTimes.length - 1) {
                    currEndIdx++;
                } else {
                    currStartIdx++;
                }
            }
        }
        return maxNumOverlaps;
    }

    public static void main(String[] args) {
        TimeInterval t1 = new TimeInterval(30, 75);
        TimeInterval t2 = new TimeInterval(0, 50);
        TimeInterval t3 = new TimeInterval(60, 150);
        ArrayList<TimeInterval> timeIntervals = new ArrayList<>();
        timeIntervals.add(t1);
        timeIntervals.add(t2);
        timeIntervals.add(t3);

        System.out.println(MinRooms.minRooms(timeIntervals)); //exp: 2
    }
}