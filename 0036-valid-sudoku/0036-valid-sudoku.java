class Solution {

    public boolean isValidSudoku(char[][] board) {

        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // Initialize sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse the board
        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                char value = board[r][c];

                // Ignore empty cells
                if (value == '.') {
                    continue;
                }

                // Find the 3 x 3 box
                int box = (r / 3) * 3 + (c / 3);

                // Check for duplicates
                if (rows[r].contains(value) ||
                    cols[c].contains(value) ||
                    boxes[box].contains(value)) {

                    return false;
                }

                // Record the digit
                rows[r].add(value);
                cols[c].add(value);
                boxes[box].add(value);
            }
        }

        return true;
    }
}