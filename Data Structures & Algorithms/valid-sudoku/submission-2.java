class Solution {

    public boolean isValidSudoku(char[][] board) {
        
        // board[row][col]

        boolean[] seen = new boolean[10];
        
        int currVal = 0;
        // char '.' = int -2
        int empty = -2;
        // check each row
        for (int row = 0; row < 9; row++) {
            Arrays.fill(seen, false);
            for (int col = 0; col < 9; col++) {
                currVal = board[row][col] - '0';
                if (currVal != -2) {
                    if (seen[currVal]) { 
                        return false; 
                    }
                    seen[currVal] = true;
                }
            }
        }

        // check each col
        for (int col = 0; col < 9; col++) {
            Arrays.fill(seen, false);
            for (int row = 0; row < 9; row++) {
                currVal = board[row][col] - '0';
                
                if (currVal != -2) {
                    if (seen[currVal]) { 
                        return false; 
                    }
                    seen[currVal] = true;
                }
            }
        }

        // check each 3x3 grid
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            
            for (int boxCol = 0; boxCol < 3; boxCol++) {

                Arrays.fill(seen, false);
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        
                        int actualRow = boxRow*3 + row;
                        int actualCol = boxCol*3 + col;

                        currVal = board[actualRow][actualCol] - '0';
                        if (currVal != -2) {
                            if (seen[currVal]) { 
                                return false; 
                            }
                            seen[currVal] = true;
                        }

                    }
                }
            }
        }
                

        return true;
    }


}
