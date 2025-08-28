class Solution {
    public int[][] sortMatrix(int[][] grid) {
       int n = grid.length;

        for (int row = 0; row < n; row++) {
            sortDiagonal(grid, row, 0, false); 
        }

        for (int col = 1; col < n; col++) {
            sortDiagonal(grid, 0, col, true); 
        }

        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col, boolean ascending) {
        int n = grid.length;
        List<Integer> diagonal = new ArrayList<>();

        int r = row, c = col;
        while (r < n && c < n) {
            diagonal.add(grid[r][c]);
            r++;
            c++;
        }

        if (ascending) {
            Collections.sort(diagonal);
        } else {
            diagonal.sort(Collections.reverseOrder());
        }

        r = row;
        c = col;
        int idx = 0;
        while (r < n && c < n) {
            grid[r][c] = diagonal.get(idx++);
            r++;
            c++;
        }
    }
}