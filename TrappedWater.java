import java.util.ArrayList;

public class TrappedWater {
    public static int min(int n1, int n2) {
        if (n1 < n2) {
            return n1;
        }
        return n2;
    }

    public static int trappedWater(int[] elevations) {
        // get the indices of the hills
        ArrayList<Integer> hills = new ArrayList<>();
        if (elevations[0] != 0 && elevations[0] > elevations[1]) {
            hills.add(0);
        }
        for (int i = 1; i < elevations.length - 1; i++) {
            if (elevations[i] > elevations[i - 1] && elevations[i] > elevations[i + 1]) {
                hills.add(i);
            }
        }
        if (elevations[elevations.length - 1] != 0 && 
                elevations[elevations.length - 1] > elevations[elevations.length - 2]) {
            hills.add(elevations.length - 1);
        }

        // testing
        // for (Integer i : hills) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();

        // get the amount of trapped water
        int trappedWaterCnt = 0;
        for (int j = 0; j < hills.size() - 1; j++) {
            int firstHillIdx = hills.get(j);
            int secondHillIdx = hills.get(j + 1);
            int minHeight = min(elevations[firstHillIdx], elevations[secondHillIdx]);
            for (int k = firstHillIdx + 1; k < secondHillIdx; k++) {
                trappedWaterCnt += minHeight - elevations[k];
            }
        }
        return trappedWaterCnt;
    }

    public static void main(String[] args) {
        int[] e1 = new int[] {2, 1, 2};
        System.out.println(TrappedWater.trappedWater(e1)); //exp: 1

        int[] e2 = new int[] {3, 0, 1, 3, 0, 5};
        System.out.println(TrappedWater.trappedWater(e2)); //exp: 8

        int[] e3 = new int[] {0, 3, 0, 0, 0};
        System.out.println(TrappedWater.trappedWater(e3)); //exp: 0

        int[] e4 = new int[] {2, 2, 2};
        System.out.println(TrappedWater.trappedWater(e4)); //exp: 0

        int[] e5 = new int[] {1, 3, 5, 3, 1};
        System.out.println(TrappedWater.trappedWater(e5)); //exp: 0
    }
}
