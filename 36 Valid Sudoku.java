class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Track seen digits for each row, column, and 3x3 sub-box
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                // Skip empty cells
                if (val == '.') {
                    continue;
                }

                int num = val - '1'; // Convert '1'-'9' to index 0-8
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If number is already seen in row, col, or box, board is invalid
                if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                    return false;
                }

                // Mark the number as seen
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true;
    }
}
