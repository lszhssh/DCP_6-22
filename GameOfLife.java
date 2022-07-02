import java.util.ArrayList;

// 6/21/22

public class GameOfLife {
    static class Cell {
        int x, y;
        char status;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            this.status = '*';
        }

        public void die() {
            this.status = '.';
        }

        public void revive() {
            this.status = '*';
        }

        public boolean isHorizNeighbor(Cell other) {
            if (this.y == other.y && Math.abs(this.x - other.x) == 1) {
                return true;
            }
            return false;
        }

        public boolean isVertNeighbor(Cell other) {
            if (this.x == other.x && Math.abs(this.y - other.y) == 1) {
                return true;
            }
            return false;
        }

        public boolean isDiagNeighbor(Cell other) {
            if (Math.abs(this.x - other.x) == 1 && Math.abs(this.y - other.y) == 1) {
                return true;
            }
            return false;
        }

        public ArrayList<Cell> getNeighbors(ArrayList<Cell> cells) {
            ArrayList<Cell> neighbors = new ArrayList<>();
            for (Cell c : cells) {
                if (c.status == '*') {
                    if (this.isHorizNeighbor(c) || this.isVertNeighbor(c) ||
                            this.isDiagNeighbor(c)) {
                        neighbors.add(c);
                    }
                }
            }
            return neighbors;
        }

        public ArrayList<Cell> getAllRelevantCells(ArrayList<Cell> cells) {
            ArrayList<Cell> deadNeighbors = new ArrayList<>();
            for (Cell c : cells) {

            }
        }
    }

    ArrayList<Cell> cells;
    int generations;

    public GameOfLife(ArrayList<Cell> cells, int generations) {
        this.cells = cells;
        this.generations = generations;
    }

    public void play() {
        for (int i = 0; i < this.generations; i++) {
            for (Cell c : this.cells) {
                ArrayList<Cell> neighbors = c.getNeighbors(cells);
                int numNeighbors = neighbors.size();
                if (c.status == '*') {
                    // alive
                    if (numNeighbors < 2 || numNeighbors > 3) {
                        c.die();
                    }
                } else {
                    // dead
                    if (numNeighbors == 3) {
                        c.revive();
                    }
                }
            }
        }
    }
}