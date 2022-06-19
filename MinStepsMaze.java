import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

// 6/5/22

public class MinStepsMaze {
    static class Pair {
        int xCoord;
        int yCoord;
        int depth;
        
        public Pair(int xCoord, int yCoord, int depth) {
            this.xCoord = xCoord;
            this.yCoord = yCoord;
            this.depth = depth;
        }
    }

    public static boolean isValidTile(boolean[][] maze, Pair position) {
        if (position.xCoord < 0 || position.xCoord >= maze.length ||
                position.yCoord < 0 || position.yCoord >= maze[0].length) {
            return false;
        }
        return !maze[position.xCoord][position.yCoord];
    }

    public static ArrayList<Pair> getValidNeighbors(boolean[][] maze, Pair currPosition) {
        ArrayList<Pair> neighbors = new ArrayList<>();
        int x = currPosition.xCoord;
        int y = currPosition.yCoord;
        int newDepth = currPosition.depth + 1;
        Pair northNeighbor = new Pair(x, y - 1, newDepth);
        if (isValidTile(maze, northNeighbor)) {
            neighbors.add(northNeighbor);
        }
        Pair eastNeighbor = new Pair(x + 1, y, newDepth);
        if (isValidTile(maze, eastNeighbor)) {
            neighbors.add(eastNeighbor);
        }
        Pair southNeighbor = new Pair(x, y + 1, newDepth);
        if (isValidTile(maze, southNeighbor)) {
            neighbors.add(southNeighbor);
        }
        Pair westNeighbor = new Pair(x - 1, y, newDepth);
        if (isValidTile(maze, westNeighbor)) {
            neighbors.add(westNeighbor);
        }
        return neighbors;
    }

    public static int minStepsMaze(boolean[][] maze, Pair start, Pair end) {
        Queue<Pair> tiles = new ArrayDeque<>();
        HashSet<Pair> seen = new HashSet<>();
        tiles.add(start);
        while (!tiles.isEmpty()) {
            Pair curr = tiles.poll();
            seen.add(curr);
            if (curr.xCoord == end.xCoord && curr.yCoord == end.yCoord) {
                return curr.depth;
            }
            ArrayList<Pair> neighbors = getValidNeighbors(maze, curr);
            for (Pair p : neighbors) {
                if (!seen.contains(p)) {
                    tiles.add(p);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean[][] maze = new boolean[][] {{false, false, false, false}, 
                                            {true, true, false, true}, 
                                            {false, false, false, false}, 
                                            {false, false, false, false}};
        Pair start = new Pair(3, 0, 0);
        Pair end = new Pair(0, 0, 0);
        System.out.println(minStepsMaze(maze, start, end));
    }
}