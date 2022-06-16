// 6/1/22

public class Houses {
    public static int minCost(int[][] costs) {
        int minCost = 0;
        for (int i = 0; i < costs[0].length; i++) {
            int totalCost = costs[0][i];
            int prevColorIdx = i;
            for (int j = 1; j < costs.length; j++) {
                int minHouseCost = 0;
                // for (int )
            }
        }
    }

    // iter thru all possible starting points for the first house
    // keep track of the color of the prev house and pick the cheapest cost for
    // the house that's not the color of the prev house
    // keep track of the best costs at each starting point and return the min
}

// 1    10    1000
// 1    8     1
// 1    12    1000

// starting at (0, 0) = 1 + 8 + 1000 = 1009
// starting at (1, 0) = 1 + 10 + 1 = 12
// starting at (2, 0) = 1 + 8 + 1000 = 1009