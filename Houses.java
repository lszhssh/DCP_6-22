// 6/1/22

public class Houses {
    public static int minCost(int[][] costs) {
        int cheapest = 0;
        int cheapestIdx = -1;
        int secondCheapest = 0;
        for (int i = 0; i < costs.length; i++) {
            int newCheapest = Integer.MAX_VALUE;
            int newCheapestIdx = -1;
            int newSecondCheapest = Integer.MAX_VALUE;
            for (int j = 0; j < costs[i].length; j++) {
                int prevCheapest = j == cheapestIdx ? secondCheapest : cheapest;
                int cost = prevCheapest + costs[i][j];
                if (cost < newCheapest) {
                    newSecondCheapest = newCheapest;
                    newCheapest = cost;
                    newCheapestIdx = j;
                } else if (cost < newSecondCheapest) {
                    newSecondCheapest = cost;
                }
            }
            cheapest = newCheapest;
            cheapestIdx = newCheapestIdx;
            secondCheapest = newSecondCheapest;
        }
        return cheapest;
    }

    public static void main(String[] args) {
        int[][] costs = new int[][] {{1, 1, 1}, {10, 8, 12}, {1000, 1, 1000}};
        System.out.println(minCost(costs));
    }
}

// 1    1    1
// 10   8    12
// 1000 1    1000

// starting at (0, 0) = 1 + 8 + 1000 = 1009
// starting at (0, 1) = 1 + 10 + 1 = 12
// starting at (0, 2) = 1 + 8 + 1000 = 1009