class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] rowArr = new boolean[row];
        boolean[] colArr = new boolean[col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0)
                {
                    rowArr[i] = true;
                    colArr[j] = true;
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
               if(rowArr[i] || colArr[j])matrix[i][j] = 0;
            }
        }
    }
}